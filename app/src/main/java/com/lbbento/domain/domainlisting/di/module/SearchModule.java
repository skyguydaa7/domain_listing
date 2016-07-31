package com.lbbento.domain.domainlisting.di.module;

import android.content.Context;
import android.view.LayoutInflater;

import com.lbbento.domain.data.repository.SearchRepository;
import com.lbbento.domain.domainlisting.di.ScopeActivity;
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

    public SearchModule(Context ctx) {
        this.ctx = ctx;
    }


    @Provides @ScopeActivity
    SearchListFragmentPresenter provideSearchFragmentPresenter(SearchRepository mSearchRepository) {
        return new SearchListFragmentPresenter(mSearchRepository);
    }

    @Provides @ScopeActivity
    SearchListAdapter provideSearchListAdapter(DepthPageTransformer depthPageTransformer) {
        return new SearchListAdapter(ctx, depthPageTransformer, (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE));
    }

    @Provides @ScopeActivity
    DepthPageTransformer provideDepthPageTransformer() {
        return new DepthPageTransformer();
    }


}
