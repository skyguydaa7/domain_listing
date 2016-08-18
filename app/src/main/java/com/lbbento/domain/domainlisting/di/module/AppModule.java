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

package com.lbbento.domain.domainlisting.di.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.lbbento.domain.data.datasource.SearchDataSource;
import com.lbbento.domain.data.entities.mapper.SearchEntityDataMapper;
import com.lbbento.domain.data.executor.JobExecutor;
import com.lbbento.domain.data.repository.SearchDataRepository;
import com.lbbento.domain.data.source.local.SearchLocalDataSource;
import com.lbbento.domain.data.source.remote.SearchRemoteDataSource;
import com.lbbento.domain.data.source.remote.api.SearchAPIService;
import com.lbbento.domain.data.source.remote.api.ServiceGenerator;
import com.lbbento.domain.domain.executor.PostExecutionThread;
import com.lbbento.domain.domain.executor.ThreadExecutor;
import com.lbbento.domain.domain.repository.SearchRepository;
import com.lbbento.domain.domainlisting.DomainListingApplication;
import com.lbbento.domain.domainlisting.UIThread;
import com.lbbento.domain.domainlisting.view.animation.DepthPageTransformer;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by lbbento on 25/07/2016.
 */

@Module
public class AppModule {
    private DomainListingApplication mDomainListingApplication;


    public AppModule(DomainListingApplication mDomainListingApplication) {
        this.mDomainListingApplication = mDomainListingApplication;
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(mDomainListingApplication);
    }

    @Provides
    @Singleton
    DomainListingApplication providesApplication() {
        return mDomainListingApplication;
    }

    @Provides
    @Singleton
    Context providesContext() {
        return mDomainListingApplication.getApplicationContext();
    }

    @Provides
    @Singleton
    UIThread providesUIThread() {
        return new UIThread();
    }


    //Repos - I know I could've done it directly in the classes - but this make the code more readable and easy to understand. - JUST DID THAT FOR LEARNING PURPOSES
    @Provides
    @Singleton
    ServiceGenerator provideServiceGenerator(Retrofit retrofit) {
        return new ServiceGenerator(retrofit);
    }

    @Provides
    @Singleton
    SearchAPIService provideSearchApiService(ServiceGenerator serviceGenerator) {
        return serviceGenerator.createService(SearchAPIService.class);
    }

    @Provides
    @Singleton
    @Named("remoteDataSource")
    SearchDataSource provideSearchRemoteDataSource(SearchAPIService searchAPIService, SearchEntityDataMapper searchEntityDataMapper) {
        return new SearchRemoteDataSource(searchAPIService, searchEntityDataMapper);
    }

    @Provides
    @Singleton
    @Named("localDataSource")
    SearchDataSource provideSearchLocalDataSource() {
        return new SearchLocalDataSource();
    }

    @Provides
    @Singleton
    SearchRepository provideSearchRepository(@Named("remoteDataSource") SearchDataSource searchRemoteDataSource,
                                                 @Named("localDataSource") SearchDataSource searchLocalDataSource) {
        return new SearchDataRepository(searchRemoteDataSource, searchLocalDataSource);
    }

    @Provides @Singleton
    DepthPageTransformer provideDepthPageTransformer() {
        return new DepthPageTransformer();
    }



    @Provides @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }
}