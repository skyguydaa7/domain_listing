package com.lbbento.domain.domainlisting.presenter;

/**
 * Created by lbbento on 30/06/2016.
 */

import com.lbbento.domain.data.entities.ListingItemEntity;
import com.lbbento.domain.data.entities.SearchEntity;
import com.lbbento.domain.domain.model.SearchModel;
import com.lbbento.domain.domainlisting.view.model.ListingItemViewModel;
import com.lbbento.domain.domainlisting.view.model.SearchViewModel;

/**
 * This specifies the methods that have to be implemented between view and presenter
 */
public interface SearchListFragmentContract {

    interface View extends BaseViewContract<Presenter> {

        void showSearch(SearchViewModel search);

        void showListingItemDetails(ListingItemViewModel mListingItemViewModel);
    }

    interface Presenter<T> extends BasePresenterContract<T> {

        // No params - exercise
        void loadSearch();

        void loadView(SearchModel search);

    }
}