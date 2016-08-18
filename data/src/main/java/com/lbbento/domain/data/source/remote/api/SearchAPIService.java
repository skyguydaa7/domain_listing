package com.lbbento.domain.data.source.remote.api;

import com.lbbento.domain.data.entities.SearchEntity;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by lbbento on 30/07/2016.
 * Class conatining the API Calls - return a Rx Observable.
 */

public interface SearchAPIService {

    @GET("searchservice.svc/mapsearch")
    Observable<SearchEntity> getMapSearch(@Query("mode") String mode, @Query("sub") String sub, @Query("pcodes") String pcodes, @Query("state") String state);

}
