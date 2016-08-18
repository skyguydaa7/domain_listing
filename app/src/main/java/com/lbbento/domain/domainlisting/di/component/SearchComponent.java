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

package com.lbbento.domain.domainlisting.di.component;

import com.lbbento.domain.domainlisting.di.ScopeActivity;
import com.lbbento.domain.domainlisting.di.module.SearchModule;
import com.lbbento.domain.domainlisting.view.fragment.SearchListFragment;

import dagger.Component;

/**
 * Created by lbbento on 30/07/2016.
 * Search Component
 */

@ScopeActivity
@Component( dependencies = {AppComponent.class}, modules = {SearchModule.class})
public interface SearchComponent {
    void inject(SearchListFragment mSearchListFragment);
}