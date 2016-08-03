package com.lbbento.domain.data.repository;

import com.lbbento.domain.data.datasource.SearchDataSource;
import com.lbbento.domain.data.model.SearchEntity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import rx.Observable;
import rx.observers.TestSubscriber;

import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by lbbento on 1/08/2016.
 */

public class SearchDataRepositoryTest {

    private SearchDataRepository searchDataRepository;

    @Mock SearchDataSource mockSearchRemoteDataSource;
    @Mock SearchDataSource mockSearchLocalDataSource;
    @Mock
    SearchEntity mockSearchEntity;


    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setUp() throws  Exception {
        MockitoAnnotations.initMocks(this);

        searchDataRepository = new SearchDataRepository(mockSearchRemoteDataSource, mockSearchLocalDataSource);

    }

    /**
     * Test if GetRemoteWorks when the database is not available
     */
    @Test public void testGetRemoteMapSearch() {

        when(mockSearchLocalDataSource.getMapSearch("mode", "sub", "pcodes", "state")).thenReturn(Observable.<SearchEntity>empty());
        when(mockSearchRemoteDataSource.getMapSearch("mode", "sub", "pcodes", "state")).thenReturn(Observable.just(mockSearchEntity));

        TestSubscriber<SearchEntity> subscriber = new TestSubscriber<>();
        searchDataRepository.getMapSearch("mode", "sub", "pcodes", "state").subscribe(subscriber);
        subscriber.awaitTerminalEvent();

        subscriber.assertNoErrors();
        subscriber.assertValue(mockSearchEntity);

        verify(mockSearchRemoteDataSource, only()).getMapSearch("mode", "sub", "pcodes", "state");
    }

    /**
     * Test if GetLocal Works when just the database is available
     */
    @Test public void testGetLocalMapSearch() {

        when(mockSearchLocalDataSource.getMapSearch("mode", "sub", "pcodes", "state")).thenReturn(Observable.just(mockSearchEntity));
        when(mockSearchRemoteDataSource.getMapSearch("mode", "sub", "pcodes", "state")).thenReturn(Observable.<SearchEntity>empty());

        TestSubscriber<SearchEntity> subscriber = new TestSubscriber<>();
        searchDataRepository.getMapSearch("mode", "sub", "pcodes", "state").subscribe(subscriber);
        subscriber.awaitTerminalEvent();

        subscriber.assertNoErrors();
        subscriber.assertValue(mockSearchEntity);

        verify(mockSearchRemoteDataSource, only()).getMapSearch("mode", "sub", "pcodes", "state");
    }

    /**
     * Test if GetLocal Works when there is no results
     */
    @Test public void testGetMapSearchNotAvailable() {

        when(mockSearchLocalDataSource.getMapSearch("mode", "sub", "pcodes", "state")).thenReturn(Observable.<SearchEntity>empty());
        when(mockSearchRemoteDataSource.getMapSearch("mode", "sub", "pcodes", "state")).thenReturn(Observable.<SearchEntity>empty());

        TestSubscriber<SearchEntity> subscriber = new TestSubscriber<>();
        searchDataRepository.getMapSearch("mode", "sub", "pcodes", "state").subscribe(subscriber);
        subscriber.awaitTerminalEvent();

        subscriber.assertNoValues();
        subscriber.assertNotCompleted();
    }
}
