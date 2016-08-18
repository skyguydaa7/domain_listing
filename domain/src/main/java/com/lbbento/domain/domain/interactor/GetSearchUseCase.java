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


package com.lbbento.domain.domain.interactor;

import android.support.annotation.NonNull;

import com.lbbento.domain.domain.executor.PostExecutionThread;
import com.lbbento.domain.domain.executor.ThreadExecutor;
import com.lbbento.domain.domain.repository.SearchRepository;

import rx.Observable;

/**
 * Created by lbbento on 3/08/2016.
 * This class is an implementation of {@link UseCase} that represents a use case for
 * retrieving a Search Result.
 */
public class GetSearchUseCase extends UseCase {

    //Params
    private String mode;
    private String sub;
    private String pcodes;
    private String state;

    private final SearchRepository mSearchRepository;

    public GetSearchUseCase(@NonNull String mode, @NonNull String sub, @NonNull String pcodes, @NonNull String state, @NonNull SearchRepository searchRepository, @NonNull ThreadExecutor threadExecutor,
                            @NonNull PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.mSearchRepository = searchRepository;
        this.mode = mode;
        this.sub = sub;
        this.pcodes = pcodes;
        this.state = state;
    }

    @Override public Observable buildUseCaseObservable() {
        return this.mSearchRepository.getMapSearch(mode, sub, pcodes, state);
    }
}
