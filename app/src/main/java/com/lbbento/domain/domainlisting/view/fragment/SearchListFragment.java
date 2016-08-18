/*
 * Copyright (C) 2016 Lucas Bento Open Source Proj.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.lbbento.domain.domainlisting.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.lbbento.domain.domainlisting.R;
import com.lbbento.domain.domainlisting.di.component.SearchComponent;
import com.lbbento.domain.domainlisting.presenter.SearchListFragmentContract;
import com.lbbento.domain.domainlisting.presenter.SearchListFragmentPresenter;
import com.lbbento.domain.domainlisting.view.activity.SearchListActivity;
import com.lbbento.domain.domainlisting.view.adapter.SearchListAdapter;
import com.lbbento.domain.domainlisting.view.adapter.SearchListLayoutManager;
import com.lbbento.domain.domainlisting.view.model.ListingItemViewModel;
import com.lbbento.domain.domainlisting.view.model.SearchViewModel;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lbbento on 25/07/2016.
 */

public class SearchListFragment extends BaseFragment implements SearchListFragmentContract.View {

    @BindView(R.id.recycler_listing) RecyclerView recyclerViewListing;
    @BindView(R.id.commom_progress) RelativeLayout progress;
    @BindView(R.id.commom_retry) RelativeLayout retry;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @Nullable @BindView(R.id.detail_content_frame) FrameLayout detailContent;

    @Inject protected SearchListFragmentPresenter mPresenter;
    @Inject protected SearchListAdapter searchListAdapter;
    @Inject protected Context context;

    public SearchListFragment() { }

    public static SearchListFragment newInstance() {
        SearchListFragment f = new SearchListFragment();

        f.setRetainInstance(true); //Components lifecycle are attached to activity - I would remove this if it was a Fragment Flow based App. Lucas Bento

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_search, container, false);

        //ButterKnife
        ButterKnife.bind(this, root);

        //RecyclerView
        setupRecyclerView();

        if (savedInstanceState == null) {
            this.showListingItemDetails(null); //Initialize empty
        }

        toolbar.setTitle(getResources().getString(R.string.app_name));
        return root;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Injection
        this.getSearchComponent().inject(this);


    }

    /**
     * Gets a component for dependency injection by its type.
     */
    @SuppressWarnings("unchecked")
    protected SearchComponent getSearchComponent() {
        return ((SearchListActivity) getActivity()).getSearchComponent();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.setView(null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.setView(this);

        if (savedInstanceState == null) {
            mPresenter.loadSearch(); //Exercise - no parameters
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }




    @Override
    public void showSearch(SearchViewModel search) {

        if (search != null) {

            if (search.getListingItemEntities() != null ) {
                this.searchListAdapter.setListingItemEntityCollection(search.getListingItemEntities());
            }
        }

        setLoadingIndicator(false);
    }

    /**
     * Show Listingitem Details when possible.
     * In this example it just show the details if it's a  7" tablet or bigger, in landscape mode.(Could've defined another rules, however, there was no strict rules so I just defined this usecase). Lucas Bento
     * @param mListingItemViewModel
     */
    @Override
    public void showListingItemDetails(ListingItemViewModel mListingItemViewModel) {
        if (detailContent != null) {
            String id = (mListingItemViewModel != null ? mListingItemViewModel.getAdId().toString() : null);
            //Initialize Detail Screen
            getChildFragmentManager()
                    .beginTransaction()
                    .replace(R.id.detail_content_frame, ListingItemDetailFragment.newInstance(id))
                    .commitAllowingStateLoss();
        }
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        this.progress.setVisibility(active ? View.VISIBLE : View.GONE);
    }

    @Override public void setRetryIndicator(boolean active) {
        this.retry.setVisibility(active ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showLoadingError() {
        //TODO Show error when rying to retrieve data
        setLoadingIndicator(false);
        setRetryIndicator(true);
    }


//    @Override
//    public void showNotFound() {
//        //TODO Show not found
//        setLoadingIndicator(false);
//
//    }

    @OnClick(R.id.bt_retry) void onButtonRetryClick() {
        mPresenter.loadSearch(); //Exercise - no parameters
    }

    private void setupRecyclerView() {
        this.searchListAdapter.setOnItemClickListener(onItemClickListener);
        this.recyclerViewListing.setLayoutManager(new SearchListLayoutManager(context));
        this.recyclerViewListing.setAdapter(searchListAdapter);
    }

    private SearchListAdapter.OnItemClickListener onItemClickListener =
            new SearchListAdapter.OnItemClickListener() {
                @Override public void onUserItemClicked(ListingItemViewModel mListingItemViewModel) {
                    if (SearchListFragment.this.mPresenter != null && mListingItemViewModel != null) {
                        SearchListFragment.this.mPresenter.onListingItemClicked(mListingItemViewModel);
                    }
                }
            };
}
