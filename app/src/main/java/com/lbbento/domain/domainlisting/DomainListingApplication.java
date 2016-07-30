package com.lbbento.domain.domainlisting;

import com.lbbento.domain.domainlisting.di.component.AppComponent;
import com.lbbento.domain.domainlisting.di.component.DaggerAppComponent;
import com.lbbento.domain.domainlisting.di.module.AppModule;
import com.lbbento.domain.domainlisting.di.module.NetModule;

/**
 * Created by lbbento on 30/07/2016.
 */

public class DomainListingApplication extends android.app.Application {
        private AppComponent appComponent;

        @Override
        public void onCreate() {
                super.onCreate();
                this.initializeInjector();
        }

        private void initializeInjector() {
                this.appComponent = DaggerAppComponent.builder()
                        .netModule(new NetModule())
                        .appModule(new AppModule(this))
                        .build();


        }

        public AppComponent getAppComponent() {
                return this.appComponent;
        }
}