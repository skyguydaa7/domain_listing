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

package com.lbbento.domain.domain.repository;

import android.support.annotation.NonNull;
import com.lbbento.domain.domain.model.SearchModel;
import rx.Observable;


/**
 * Created by lbbento on 30/07/2016.
 * Implements the Search repository at the domain level
 */

public interface SearchRepository {
    /**
     * Get an {@link rx.Observable} which will emit a {@link SearchModel}.
     *
     * @param mode = search mode
     * @param sub = search suburb to filter
     * @param pcodes - search pcodes to filter
     * @param state - search state to filter
     */
    Observable<SearchModel> getMapSearch(@NonNull String mode, @NonNull String sub, @NonNull String pcodes, @NonNull String state);
}