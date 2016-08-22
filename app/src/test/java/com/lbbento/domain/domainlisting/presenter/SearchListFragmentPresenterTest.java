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

import com.lbbento.domain.domain.interactor.GetSearchUseCase;
import com.lbbento.domain.domainlisting.mapper.SearchDataMapper;
import com.lbbento.domain.domainlisting.view.model.SearchViewModel;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import rx.Subscriber;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

/**
 * Created by lbbento on 1/08/2016.
 */

public class SearchListFragmentPresenterTest {

    SearchListFragmentPresenter mSearchListFragmentPresenter;

    @Mock SearchDataMapper mSearchDataMapper;
    @Mock GetSearchUseCase mGetSearchUseCase;
    @Mock SearchListFragmentContract.View mockSearchView;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        mSearchListFragmentPresenter = new SearchListFragmentPresenter(mGetSearchUseCase, mSearchDataMapper);
        mSearchListFragmentPresenter.setView(mockSearchView);
    }

    @Test
    public void testSearchListFragmentPresenter() {
        mSearchListFragmentPresenter.loadSearch();

        verify(mockSearchView).setLoadingIndicator(true);
        verify(mGetSearchUseCase).execute(any(Subscriber.class));

    }


}
