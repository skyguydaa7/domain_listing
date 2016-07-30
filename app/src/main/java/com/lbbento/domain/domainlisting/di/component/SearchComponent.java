package com.lbbento.domain.domainlisting.di.component;

import com.lbbento.domain.domainlisting.di.ScopeActivity;
import com.lbbento.domain.domainlisting.di.module.SearchModule;
import com.lbbento.domain.domainlisting.search.SearchListFragment;

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