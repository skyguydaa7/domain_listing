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

package com.lbbento.domain.data.source.remote;

import android.support.annotation.NonNull;

import com.lbbento.domain.data.datasource.SearchDataSource;
import com.lbbento.domain.data.entities.SearchEntity;
import com.lbbento.domain.data.entities.mapper.SearchEntityDataMapper;
import com.lbbento.domain.data.source.remote.api.SearchAPIService;
import com.lbbento.domain.domain.model.SearchModel;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by lbbento on 30/07/2016.
 * Remote DataSource, define how the model gets data from the cloud.
 */
public class SearchRemoteDataSource implements SearchDataSource {

    private final SearchAPIService mSearchAPIService;
    private final SearchEntityDataMapper mSearchEntityDataMapper;

    public SearchRemoteDataSource(SearchAPIService mSearchAPIService, SearchEntityDataMapper mSearchEntityDataMapper) {
        this.mSearchAPIService = mSearchAPIService;
        this.mSearchEntityDataMapper = mSearchEntityDataMapper;
    }

    @Override
    public Observable<SearchModel> getMapSearch(@NonNull String mode, @NonNull String sub, @NonNull String pcodes, @NonNull String state) {


        return mSearchAPIService
                .getMapSearch(mode, sub, pcodes, state)
                .map(new Func1<SearchEntity, SearchModel>() {
                    @Override
                    public SearchModel call(SearchEntity searchEntity) {
                        return SearchRemoteDataSource.this.mSearchEntityDataMapper.transform(searchEntity);
                    }
                })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
                    //TODO - save to DB
                    //.doOnNext();

    }

}