package com.lbbento.domain.domainlisting.presenter;

/**
 * Created by lbbento on 30/06/2016.
 */

import com.lbbento.domain.data.model.ListingItemEntity;
import com.lbbento.domain.data.model.SearchEntity;

/**
 * This specifies the methods that have to be implemented between view and presenter
 */
public interface SearchListFragmentContract {

    interface View extends BaseViewContract<Presenter> {

        void showSearch(SearchEntity search);

        void showListingItemDetails(ListingItemEntity listingItemEntity);

        void showNotFound();
    }

    interface Presenter<T> extends BasePresenterContract<T> {

        // No params - exercise
        void loadSearch();

        void loadView(SearchEntity search);

        void refresh();

    }
}