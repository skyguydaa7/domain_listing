package com.lbbento.domain.domainlisting.di.module;

import android.content.Context;
import android.view.LayoutInflater;

import com.lbbento.domain.domain.executor.PostExecutionThread;
import com.lbbento.domain.domain.executor.ThreadExecutor;
import com.lbbento.domain.domain.interactor.GetSearchUseCase;
import com.lbbento.domain.domain.interactor.UseCase;
import com.lbbento.domain.domain.repository.SearchRepository;
import com.lbbento.domain.domainlisting.di.ScopeActivity;
import com.lbbento.domain.domainlisting.mapper.SearchDataMapper;
import com.lbbento.domain.domainlisting.presenter.SearchListFragmentPresenter;
import com.lbbento.domain.domainlisting.view.adapter.SearchListAdapter;
import com.lbbento.domain.domainlisting.view.animation.DepthPageTransformer;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lbbento on 30/07/2016.
 * Search Module - Provide Dependencies
 */

@Module
public class SearchModule {
    Context ctx;

    //Fixed Params for testing purposes
    //Use case proposed by Domain - Exercise
    //Search Params are fixed because it's an exercise.
    String mode = "buy";
    String sub = "Bondi";
    String pcodes = "2026";
    String state = "NSW";


    public SearchModule(Context ctx) {
        this.ctx = ctx;
    }


    @Provides @ScopeActivity
    SearchListFragmentPresenter provideSearchFragmentPresenter(GetSearchUseCase mSearchUseCase, SearchDataMapper mSearchDataMapper) {
        return new SearchListFragmentPresenter(mSearchUseCase, mSearchDataMapper);
    }

    @Provides @ScopeActivity
    SearchListAdapter provideSearchListAdapter(DepthPageTransformer depthPageTransformer) {
        return new SearchListAdapter(ctx, depthPageTransformer, (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE));
    }


    @Provides @ScopeActivity
    SearchDataMapper provideSearchDataMapper() {
        return new SearchDataMapper();
    }

    @Provides @ScopeActivity
    GetSearchUseCase provideGetSearchUseCase(SearchRepository searchRepository, ThreadExecutor threadExecutor,
                                             PostExecutionThread postExecutionThread) {
        return  new GetSearchUseCase(mode, sub, pcodes, state, searchRepository, threadExecutor, postExecutionThread);
    }



}
