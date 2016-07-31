package com.lbbento.domain.domainlisting.view.activity;

import android.os.Bundle;

import com.lbbento.domain.domainlisting.R;
import com.lbbento.domain.domainlisting.di.component.DaggerSearchComponent;
import com.lbbento.domain.domainlisting.di.component.SearchComponent;
import com.lbbento.domain.domainlisting.di.module.SearchModule;
import com.lbbento.domain.domainlisting.view.fragment.SearchListFragment;

public class MainActivity extends BaseActivity {


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
