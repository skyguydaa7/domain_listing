package com.lbbento.domain.domain.interactor;

import android.support.annotation.NonNull;

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
    private String mode;
    private String sub;
    private String pcodes;
    private String state;

    private final SearchRepository mSearchRepository;

    public GetSearchUseCase(@NonNull String mode, @NonNull String sub, @NonNull String pcodes, @NonNull String state, @NonNull SearchRepository searchRepository, @NonNull ThreadExecutor threadExecutor,
                            @NonNull PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.mSearchRepository = searchRepository;
        this.mode = mode;
        this.sub = sub;
        this.pcodes = pcodes;
        this.state = state;
    }

    @Override public Observable buildUseCaseObservable() {
        return this.mSearchRepository.getMapSearch(mode, sub, pcodes, state);
    }
}
