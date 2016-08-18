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

package com.lbbento.domain.domainlisting.view.activity;

import android.os.Bundle;

import com.lbbento.domain.domainlisting.R;
import com.lbbento.domain.domainlisting.di.component.DaggerSearchComponent;
import com.lbbento.domain.domainlisting.di.component.SearchComponent;
import com.lbbento.domain.domainlisting.di.module.SearchModule;
import com.lbbento.domain.domainlisting.view.fragment.SearchListFragment;

public class SearchListActivity extends BaseActivity {


    //DI Components
    SearchComponent mSearchComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Injectors to be used by Fragments
        initializeInjectors();

        if (savedInstanceState == null) {
            //Initialize fragment
            addFragment(R.id.main_content_frame, SearchListFragment.newInstance());
        }

    }

    private void initializeInjectors() {
        this.mSearchComponent = DaggerSearchComponent.builder()
                .appComponent(getAppComponent())
                .searchModule(new SearchModule(getApplicationContext()))
                .build();
    }

    //Components
    public SearchComponent getSearchComponent() {
        return mSearchComponent;
    }

}
