package com.lbbento.domain.data.source.remote;

import android.support.annotation.NonNull;

import com.lbbento.domain.data.datasource.SearchDataSource;
import com.lbbento.domain.data.model.SearchEntity;
import com.lbbento.domain.data.source.remote.api.SearchAPIService;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by lbbento on 30/07/2016.
 * Remote DataSource, define how the model gets data from the cloud.
 */
public class SearchRemoteDataSource implements SearchDataSource {

    SearchAPIService mSearchAPIService;

    public SearchRemoteDataSource(SearchAPIService mSearchAPIService) {
        this.mSearchAPIService = mSearchAPIService;
    }

    @Override
    public Observable<SearchEntity> getMapSearch(@NonNull String mode, @NonNull String sub, @NonNull String pcodes, @NonNull String state) {


        //Usually, we would test each param and build our params string - just keeping the example simples as it just does one call.
        Map<String, String> params = new HashMap<>();
        params.put("mode", mode);
        params.put("sub", sub);
        params.put("pcodes", pcodes);
        params.put("state", state);

        return mSearchAPIService
                .getMapSearch(params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
                    //TODO - save to DB
                    //.doOnNext();

    }

}