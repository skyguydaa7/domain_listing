package com.lbbento.domain.data.source.local;

import android.support.annotation.NonNull;

import com.lbbento.domain.data.datasource.SearchDataSource;
import com.lbbento.domain.data.model.SearchModel;

import rx.Observable;


/**
 * Created by lbbento on 30/07/2016.
 * LocalDataSource - It's not going to be developed in this example, but it could be a layer accessing a ContentProvider.
 */
public class SearchLocalDataSource implements SearchDataSource {

    public SearchLocalDataSource() {

    }

    @Override
    public Observable<SearchModel> getMapSearch(@NonNull String mode, @NonNull String sub, @NonNull String pcodes, @NonNull String state) {

        //TODO - GET FROM LOCAL DATABASE - ContentProvider
        return Observable.just(null);
    }
}
