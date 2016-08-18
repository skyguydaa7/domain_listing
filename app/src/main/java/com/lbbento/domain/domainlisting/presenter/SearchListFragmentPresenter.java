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

package com.lbbento.domain.domainlisting.presenter;

import android.support.annotation.NonNull;

import com.lbbento.domain.domain.interactor.DefaultSubscriber;
import com.lbbento.domain.domain.interactor.UseCase;
import com.lbbento.domain.domain.model.SearchModel;
import com.lbbento.domain.domainlisting.di.ScopeActivity;
import com.lbbento.domain.domainlisting.mapper.SearchDataMapper;
import com.lbbento.domain.domainlisting.view.model.ListingItemViewModel;
import com.lbbento.domain.domainlisting.view.model.SearchViewModel;

/**
 * Created by lbbento on 30/07/2016.
 */

@ScopeActivity
public class SearchListFragmentPresenter implements SearchListFragmentContract.Presenter<SearchListFragmentContract.View> {

    protected SearchListFragmentContract.View view;
    private final SearchDataMapper searchDataMapper;
    private final UseCase getSearchUseCase;


    public SearchListFragmentPresenter(@NonNull UseCase getSearchUseCase, SearchDataMapper searchDataMapper) {
        this.searchDataMapper = searchDataMapper;
        this.getSearchUseCase = getSearchUseCase;
    }


    @Override
    public void setView(@NonNull SearchListFragmentContract.View view) {
        this.view = view;

    }

    @Override
    public void setLoading(boolean active) {
        view.setLoadingIndicator(active);
    }

    @Override
    public void setRetry(boolean active) {
        view.setRetryIndicator(false);
    }

    @Override
    public void showError() {
        //TODO showError
    }



    @Override
    public void loadSearch() {

        this.getSearchUseCase.execute(new SearchSubscriber());

    }


    private final class SearchSubscriber extends DefaultSubscriber<SearchModel> {

        @Override public void onCompleted() {
            SearchListFragmentPresenter.this.setLoading(false);
        }

        @Override public void onError(Throwable e) {
            SearchListFragmentPresenter.this.setLoading(false);
            SearchListFragmentPresenter.this.showError();
            SearchListFragmentPresenter.this.setRetry(true);
        }

        @Override public void onNext(SearchModel searchModel) {
            SearchListFragmentPresenter.this.loadView(searchModel);
        }
    }

    @Override
    public void loadView(SearchModel pSearchModel) {
        final SearchViewModel searchViewModel = this.searchDataMapper.transform(pSearchModel);
        this.view.showSearch(searchViewModel);
    }

    public void onListingItemClicked(ListingItemViewModel mListingItemViewModel) {
        view.showListingItemDetails(mListingItemViewModel);
    }


}