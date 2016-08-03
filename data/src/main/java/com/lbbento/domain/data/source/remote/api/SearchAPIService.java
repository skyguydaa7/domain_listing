package com.lbbento.domain.data.source.remote.api;

import com.lbbento.domain.data.model.SearchEntity;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by lbbento on 30/07/2016.
 * Class conatining the API Calls - return a Rx Observable.
 */

public interface SearchAPIService {

    @GET("searchservice.svc/mapsearch")
    Observable<SearchEntity> getMapSearch(@QueryMap Map<String, String> searchParams);

}
