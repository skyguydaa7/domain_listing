package com.lbbento.domain.data.datasource;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.lbbento.domain.data.model.SearchEntity;

import rx.Observable;

/**
 * Created by lbbento on 30/07/2016.
 * Interface that defines the SearchDataSource.
 */

public interface SearchDataSource {

    Observable<SearchEntity> getMapSearch(@Nullable String mode, @Nullable String sub, @Nullable String pcodes, @NonNull String state);

}