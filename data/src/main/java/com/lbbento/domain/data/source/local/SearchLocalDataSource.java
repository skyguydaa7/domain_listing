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

package com.lbbento.domain.data.source.local;

import android.support.annotation.NonNull;

import com.lbbento.domain.data.datasource.SearchDataSource;
import com.lbbento.domain.domain.model.SearchModel;

import rx.Observable;


/**
 * Created by lbbento on 30/07/2016.
 * LocalDataSource - It's not going to be developed in this example, but it could be a layer accessing a ContentProvider.
 */
public class SearchLocalDataSource implements SearchDataSource {

    public SearchLocalDataSource() {

    }

    @Override
    public Observable<SearchModel> getMapSearch(@NonNull String mode, @NonNull String sub, @NonNull String pcodes, @NonNull String state) {

        //TODO - GET FROM LOCAL DATABASE - ContentProvider
        return Observable.just(null);
    }
}
