package com.lbbento.domain.domainlisting.presenter;

/**
 * Created by lbbento on 30/06/2016.
 */

import com.lbbento.domain.data.model.ListingItem;
import com.lbbento.domain.data.model.SearchModel;

/**
 * This specifies the methods that have to be implemented between view and presenter
 */
public interface SearchListFragmentContract {

    interface View extends BaseViewContract<Presenter> {

        void showSearch(SearchModel search);

        void showListingItemDetails(ListingItem listingItem);

        void showNotFound();
    }

    interface Presenter<T> extends BasePresenterContract<T> {

        // No params - exercise
        void loadSearch();

        void refresh();

    }
}