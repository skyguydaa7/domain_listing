package com.lbbento.domain.data.repository;

import android.support.annotation.NonNull;

import com.lbbento.domain.data.datasource.SearchDataSource;
import com.lbbento.domain.data.model.SearchEntity;

import rx.Observable;
import rx.functions.Func1;


/**
 * Created by lbbento on 30/07/2016.
 * Implements the Search repository - if the App were more complex. There would be a domain layer in between these calls.
 */
public class SearchDataRepository implements SearchDataSource {

    private final SearchDataSource mSearchRemoteDataSource;
    private final SearchDataSource mSearchLocalDataSource;

    public SearchDataRepository(@NonNull SearchDataSource mSearchRemoteDataSource,
                                @NonNull SearchDataSource mSearchLocalDataSource) {
        this.mSearchRemoteDataSource = mSearchRemoteDataSource;
        this.mSearchLocalDataSource = mSearchLocalDataSource;
    }



    /**
     * Gets search from local data source if available, otherwise
     * uses the network data source.
     */
    @Override
    public Observable<SearchEntity> getMapSearch(@NonNull String mode, @NonNull String sub, @NonNull String pcodes, @NonNull String state) {

        final Observable<SearchEntity> obs = Observable.concat(
                mSearchLocalDataSource.getMapSearch(mode, sub, pcodes, state),
                mSearchRemoteDataSource.getMapSearch(mode, sub, pcodes, state)
        )
        .first(new Func1<SearchEntity, Boolean>() {
            @Override
            public Boolean call(SearchEntity mSearchModel) {
                return (mSearchModel != null);
            }
        });

        return obs;
    }


}