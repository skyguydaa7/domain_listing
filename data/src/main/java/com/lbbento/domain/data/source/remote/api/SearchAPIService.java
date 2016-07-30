package com.lbbento.domain.data.source.remote.api;

import com.lbbento.domain.data.model.SearchModel;

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
    Observable<SearchModel> getMapSearch(@QueryMap Map<String, String> searchParams);

}
