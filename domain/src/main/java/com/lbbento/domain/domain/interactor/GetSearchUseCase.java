package com.lbbento.domain.domain.interactor;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.lbbento.domain.domain.executor.PostExecutionThread;
import com.lbbento.domain.domain.executor.ThreadExecutor;
import com.lbbento.domain.domain.repository.SearchRepository;

import rx.Observable;

/**
 * Created by lbbento on 3/08/2016.
 * This class is an implementation of {@link UseCase} that represents a use case for
 * retrieving a Search Result.
 */
public class GetSearchUseCase extends UseCase {

    //Params
    private final String mode;
    private final String suburb;
    private final String pCodes;
    private final String state;

    private final SearchRepository mSearchRepository;

    public GetSearchUseCase(@NonNull SearchParams, SearchRepository searchRepository, ThreadExecutor threadExecutor,
                            PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.mSearchRepository = searchRepository;
    }

    @Override public Observable buildUseCaseObservable() {
        return this.mSearchRepository.users();
    }
}
