package com.lbbento.domain.domainlisting.di.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.lbbento.domain.data.datasource.SearchDataSource;
import com.lbbento.domain.data.repository.SearchRepository;
import com.lbbento.domain.data.source.local.SearchLocalDataSource;
import com.lbbento.domain.data.source.remote.SearchRemoteDataSource;
import com.lbbento.domain.data.source.remote.api.SearchAPIService;
import com.lbbento.domain.data.source.remote.api.ServiceGenerator;
import com.lbbento.domain.domainlisting.DomainListingApplication;

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

    @Provides @Singleton SharedPreferences provideSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(mDomainListingApplication);
    }

    @Provides @Singleton DomainListingApplication providesApplication() {
        return mDomainListingApplication;
    }

    @Provides @Singleton Context providesContext() {
        return mDomainListingApplication.getApplicationContext();
    }




    //Repos - I know I could've done it directly in the classes - but this make the code more readable and easy to understand. - JUST DID THAT FOR LEARNING PURPOSES
    @Provides @Singleton ServiceGenerator provideServiceGenerator(Retrofit retrofit) {
        return new ServiceGenerator(retrofit);
    }

    @Provides @Singleton SearchAPIService provideSearchApiService(ServiceGenerator serviceGenerator) {
        return serviceGenerator.createService(SearchAPIService.class);
    }

    @Provides @Singleton @Named("remoteDataSource") SearchDataSource provideSearchRemoteDataSource(SearchAPIService searchAPIService) {
        return new SearchRemoteDataSource(searchAPIService);
    }

    @Provides @Singleton @Named("localDataSource") SearchDataSource provideSearchLocalDataSource() {
        return new SearchLocalDataSource();
    }

    @Provides @Singleton SearchRepository provideSearchRepository(@Named("remoteDataSource") SearchDataSource searchRemoreDataSource,
                                             @Named("localDataSource") SearchDataSource searchLocalDataSource) {
        return new SearchRepository(searchRemoreDataSource, searchLocalDataSource);
    }


}
