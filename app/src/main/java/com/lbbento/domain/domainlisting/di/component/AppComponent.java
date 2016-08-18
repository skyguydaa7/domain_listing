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

import android.content.Context;

import com.lbbento.domain.domain.executor.PostExecutionThread;
import com.lbbento.domain.domain.executor.ThreadExecutor;
import com.lbbento.domain.domain.repository.SearchRepository;
import com.lbbento.domain.domainlisting.di.module.AppModule;
import com.lbbento.domain.domainlisting.di.module.NetModule;
import com.lbbento.domain.domainlisting.view.activity.BaseActivity;
import com.lbbento.domain.domainlisting.view.animation.DepthPageTransformer;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by lbbento on 25/07/2016.
 */

@Component(
        modules = {AppModule.class,NetModule.class}
)
@Singleton // Constraints this component to one-per-application or unscoped bindings.
public interface AppComponent {
    void inject(BaseActivity activity);

    //Exposed to sub-graphs. - with this, SearchComponent can inject the Context from the dependency(this)
    Context context();

    //Repos - to sub-graphs
    SearchRepository searchRepository();
    DepthPageTransformer mDepthPageTransformer();
    ThreadExecutor mThreadExecutor();
    PostExecutionThread mPostExecutionThread();

}