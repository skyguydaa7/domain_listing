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

package com.lbbento.domain.data.source.remote.api;

import com.lbbento.domain.data.entities.SearchEntity;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by lbbento on 30/07/2016.
 * Class conatining the API Calls - return a Rx Observable.
 */

public interface SearchAPIService {

    @GET("searchservice.svc/mapsearch")
    Observable<SearchEntity> getMapSearch(@Query("mode") String mode, @Query("sub") String sub, @Query("pcodes") String pcodes, @Query("state") String state);

}
