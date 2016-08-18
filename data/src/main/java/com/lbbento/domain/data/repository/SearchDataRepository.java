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

package com.lbbento.domain.data.repository;

import android.support.annotation.NonNull;

import com.lbbento.domain.data.datasource.SearchDataSource;
import com.lbbento.domain.domain.model.SearchModel;
import com.lbbento.domain.domain.repository.SearchRepository;

import rx.Observable;
import rx.functions.Func1;


/**
 * Created by lbbento on 30/07/2016.
 * Implements the Search repository - if the App were more complex. There would be a domain layer in between these calls.
 */
public class SearchDataRepository implements SearchRepository {

    private final SearchDataSource mSearchRemoteDataSource;
    private final SearchDataSource mSearchLocalDataSource;

    public SearchDataRepository(@NonNull SearchDataSource mSearchRemoteDataSource,
                                @NonNull SearchDataSource mSearchLocalDataSource) {
        this.mSearchRemoteDataSource = mSearchRemoteDataSource;
        this.mSearchLocalDataSource = mSearchLocalDataSource;
    }



    /**
     * Gets search from local data source if available, otherwise
     * uses the network data source.
     */
    @Override
    public Observable<SearchModel> getMapSearch(@NonNull String mode, @NonNull String sub, @NonNull String pcodes, @NonNull String state) {

        final Observable<SearchModel> obs = Observable.concat(
                mSearchLocalDataSource.getMapSearch(mode, sub, pcodes, state),
                mSearchRemoteDataSource.getMapSearch(mode, sub, pcodes, state)
        )
                .first(new Func1<SearchModel, Boolean>() {
                    @Override
                    public Boolean call(SearchModel mSearchModel) {
                        return (mSearchModel != null);
                    }
                });

        return obs;
    }


}