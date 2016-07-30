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
