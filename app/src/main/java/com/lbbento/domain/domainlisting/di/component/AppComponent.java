package com.lbbento.domain.domainlisting.di.component;

import android.content.Context;

import com.lbbento.domain.domain.repository.SearchRepository;
import com.lbbento.domain.domainlisting.di.module.AppModule;
import com.lbbento.domain.domainlisting.di.module.NetModule;
import com.lbbento.domain.domainlisting.view.activity.BaseActivity;

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

}