package com.lbbento.domain.domainlisting.search;

/**
 * Created by lbbento on 30/06/2016.
 */

import com.lbbento.domain.data.model.SearchModel;
import com.lbbento.domain.domainlisting.base.BaseFragmentContract;
import com.lbbento.domain.domainlisting.base.BasePresenterContract;

/**
 * This specifies the methods that have to be implemented between view and presenter
 */
public interface SearchListFragmentContract {

    interface View extends BaseFragmentContract<Presenter> {

        void showSearch(SearchModel search);

        void showNotFound();
    }

    interface Presenter<T> extends BasePresenterContract<T> {

        // No params - exercise
        void loadSearch();

        void refresh();

    }
}