package com.lbbento.domain.domainlisting.presenter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.lbbento.domain.data.model.ListingItem;
import com.lbbento.domain.data.model.SearchModel;
import com.lbbento.domain.data.repository.SearchRepository;
import com.lbbento.domain.domainlisting.view.fragment.SearchListFragment;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * Created by lbbento on 30/07/2016.
 */

public class SearchListFragmentPresenter implements SearchListFragmentContract.Presenter<SearchListFragment> {

    private final SearchRepository mSearchRepository;
    private SearchListFragmentContract.View view;

    @Nullable
    private Subscription mSubscription = Subscriptions.empty();

    public SearchListFragmentPresenter(@NonNull SearchRepository mSearchRepository) {
        this.mSearchRepository = mSearchRepository;
    }


    @Override
    public void setView(SearchListFragment view) {
        this.view = view;
        if (view == null) {
            mSubscription.unsubscribe();
        }

    }


    @Override
    public void refresh() {
        loadSearch();
    }

    @Override
    public void loadSearch() {

        view.setLoadingIndicator(true);


        //Use case proposed by Domain - Exercise
        //Search Params are fixed because it's an exercise.
        String mode = "buy";
        String suburb = "Bondi";
        String pcodes = "2026";
        String state = "NSW";



        mSubscription = mSearchRepository
                .getMapSearch(mode, suburb, pcodes, state)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SearchModel>() {
                    @Override
                    public void onCompleted() {
                        view.setLoadingIndicator(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showLoadingError();
                    }

                    @Override
                    public void onNext(SearchModel search) {
                        view.showSearch(search);
                    }
                });
    }

    public void onListingItemClicked(ListingItem mListingItem) {
        view.showListingItemDetails(mListingItem);
    }

}