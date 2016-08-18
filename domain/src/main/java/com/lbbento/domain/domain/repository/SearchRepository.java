package com.lbbento.domain.domain.repository;

import android.support.annotation.NonNull;

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
     * @param mode = search mode
     * @param sub = search suburb to filter
     * @param pcodes - search pcodes to filter
     * @param state - search state to filter
     */
    Observable<SearchModel> getMapSearch(@NonNull String mode, @NonNull String sub, @NonNull String pcodes, @NonNull String state);
}