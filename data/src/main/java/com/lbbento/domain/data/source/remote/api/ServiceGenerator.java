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

package com.lbbento.domain.data.source.remote.api;

import retrofit2.Retrofit;

/**
 * Created by lbbento on 30/07/2016.
 * Generates the Service to access the API. If there was authentication, token refresh, etc. It would be the place to intercept it.
 */

public class ServiceGenerator {

    Retrofit mRetrofit;

    /**
     * Create the service generator
     * @param retrofit - Retrofit instance - See @{@link com.lbbento.domain.domainlisting.di.module.NetModule} for reference.
     */
    public ServiceGenerator(Retrofit retrofit) {
        this.mRetrofit = retrofit;
    }

    public <S> S createService(Class<S> serviceClass) {
        return mRetrofit.create(serviceClass);
    }


}
