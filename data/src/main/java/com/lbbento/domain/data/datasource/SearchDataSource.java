package com.lbbento.domain.data.datasource;

import android.support.annotation.NonNull;
import com.lbbento.domain.data.model.SearchModel;

import rx.Observable;

/**
 * Created by lbbento on 30/07/2016.
 * Interface that defines the SearchDataSource.
 */

public interface SearchDataSource {

    Observable<SearchModel> getMapSearch(@NonNull String mode, @NonNull String sub, @NonNull String pcodes, @NonNull String state);

}