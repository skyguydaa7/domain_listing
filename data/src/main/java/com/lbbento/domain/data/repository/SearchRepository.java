package com.lbbento.domain.data.repository;

import android.support.annotation.NonNull;

import com.lbbento.domain.data.datasource.SearchDataSource;
import com.lbbento.domain.data.model.SearchModel;

import rx.Observable;
import rx.functions.Func1;


/**
 * Created by lbbento on 30/07/2016.
 * Implements the Search repository - if the App were more complex. There would be a domain layer in between these calls.
 */
public class SearchRepository implements SearchDataSource {

    private final SearchDataSource mSearchRemoteDataSource;
    private final SearchDataSource mSearchLocalDataSource;

    public SearchRepository(@NonNull SearchDataSource mSearchRemoteDataSource,
                            @NonNull SearchDataSource mSearchLocalDataSource) {
        this.mSearchRemoteDataSource = mSearchRemoteDataSource;
        this.mSearchLocalDataSource = mSearchLocalDataSource;
    }



    /**
     * Gets search from local data source if available, otherwise
     * uses the network data source.
     */
    @Override
    public Observable<SearchModel> getMapSearch(@NonNull String mode, @NonNull String sub, @NonNull String pcodes, @NonNull String state) {

        final Observable<SearchModel> obs = Observable.concat(
                mSearchLocalDataSource.getMapSearch(mode, sub, pcodes, state),
                mSearchRemoteDataSource.getMapSearch(mode, sub, pcodes, state)
        )
        .first(new Func1<SearchModel, Boolean>() {
            @Override
            public Boolean call(SearchModel mSearchModel) {
                return (mSearchModel != null);
            }
        });

        return obs;
    }


}