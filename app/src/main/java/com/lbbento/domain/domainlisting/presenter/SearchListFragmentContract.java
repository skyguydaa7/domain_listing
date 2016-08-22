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

/**
 * Created by lbbento on 30/06/2016.
 */

import android.content.Context;

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

        Context getContext();
    }

    interface Presenter<T> extends BasePresenterContract<T> {

        // No params - exercise
        void loadSearch();

        void loadView(SearchModel search);

    }
}