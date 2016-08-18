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

        /**
         * Visible only for testing purposes.
         */
        public void setTestComponent(AppComponent testingComponent) {
                appComponent = testingComponent;
        }
}