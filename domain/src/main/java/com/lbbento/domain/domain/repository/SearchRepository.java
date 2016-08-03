package com.lbbento.domain.domain.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.lbbento.domain.domain.model.SearchModel;

import rx.Observable;


/**
 * Created by lbbento on 30/07/2016.
 * Implements the Search repository at the domain level
 */

public interface SearchRepository {
    /**
     * Get an {@link rx.Observable} which will emit a {@link SearchModel}.
     *
     * @param mode Search mode
     * @param sub  Suburb to filter by
     * @param pcodes PCodes list
     * @param  state State to filter by
     */
    Observable<SearchModel> search(@Nullable String mode, @Nullable String sub, @Nullable String pcodes, @NonNull String state);
}