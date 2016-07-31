package com.lbbento.domain.domainlisting.search;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lbbento.domain.data.model.ListingItem;
import com.lbbento.domain.data.model.SearchModel;
import com.lbbento.domain.domainlisting.R;
import com.lbbento.domain.domainlisting.base.BaseFragment;
import com.lbbento.domain.domainlisting.di.component.SearchComponent;
import com.lbbento.domain.domainlisting.listing.ListingItemDetailFragment;
import com.lbbento.domain.domainlisting.main.MainActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lbbento on 25/07/2016.
 */

public class SearchListFragment extends BaseFragment implements SearchListFragmentContract.View {

    @BindView(R.id.recycler_listing) RecyclerView recyclerViewListing;
    @BindView(R.id.commom_progress) RelativeLayout progress;
    @BindView(R.id.commom_retry) RelativeLayout retry;
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
            showListingItemDetails(null); //Initialize empty
        }

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
        return ((MainActivity) getActivity()).getSearchComponent();
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
    public void showSearch(SearchModel search) {

        if (search != null) {

            if (search.getListingResult() != null && search.getListingResult().getListingItems() != null) {
                this.searchListAdapter.setListingItemCollection(search.getListingResult().getListingItems());
            }
        }

        setLoadingIndicator(false);
    }

    /**
     * Show Listingitem Details when possible.
     * In this example it just show the details if it's a  7" tablet or bigger, in landscape mode.(Could've defined another rules, however, there was no strict rules so I just defined this usecase). Lucas Bento
     * @param listingItem
     */
    @Override
    public void showListingItemDetails(ListingItem listingItem) {
        if (detailContent != null) {
            String id = (listingItem != null ? listingItem.getAdId().toString() : null);
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


    @Override
    public void showNotFound() {
        //TODO Show not found
        setLoadingIndicator(false);

    }

    private void setupRecyclerView() {
        this.searchListAdapter.setOnItemClickListener(onItemClickListener);
        this.recyclerViewListing.setLayoutManager(new SearchListLayoutManager(context));
        this.recyclerViewListing.setAdapter(searchListAdapter);
    }

    private SearchListAdapter.OnItemClickListener onItemClickListener =
            new SearchListAdapter.OnItemClickListener() {
                @Override public void onUserItemClicked(ListingItem userModel) {
                    if (SearchListFragment.this.mPresenter != null && userModel != null) {
                        SearchListFragment.this.mPresenter.onListingItemClicked(userModel);
                    }
                }
            };
}
