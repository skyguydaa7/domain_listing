package com.lbbento.domain.domainlisting.presenter;

import com.lbbento.domain.data.datasource.SearchDataSource;
import com.lbbento.domain.data.model.SearchEntity;
import com.lbbento.domain.domain.repository.SearchRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import rx.Observable;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by lbbento on 1/08/2016.
 */

public class SearchListFragmentPresenterTest {


    SearchListFragmentPresenter mSearchListFragmentPresenter;
    SearchRepository mSearchRepository;

    @Mock SearchDataSource mockSearchRemoteDataSource;
    @Mock SearchDataSource mockSearchLocalDataSource;
    @Mock SearchListFragmentContract.View mockSearchView;
    @Mock
    SearchEntity mockSearchEntity;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        mSearchRepository = new SearchRepository(mockSearchRemoteDataSource, mockSearchLocalDataSource);
        mSearchListFragmentPresenter = new SearchListFragmentPresenter(mSearchRepository);
        mSearchListFragmentPresenter.setView(mockSearchView);
    }

    @Test
    public void testSearchListFragmentPresenter() {
        when(mSearchRepository.getMapSearch(anyString(), anyString(), anyString(),anyString())).thenReturn(Observable.just(mockSearchEntity));

        mSearchListFragmentPresenter.loadView(mockSearchEntity);

        verify(mockSearchView).showSearch(any(SearchEntity.class));

    }


}
