package com.lbbento.domain.domain.interactor;

/**
 * Created by lbbento on 3/08/2016.
 * It creates a commom interface to interact with the domain layer
 */
public class DefaultSubscriber<T> extends rx.Subscriber<T> {
    @Override public void onCompleted() {
        // no-op by default.
    }

    @Override public void onError(Throwable e) {
        // no-op by default.
    }

    @Override public void onNext(T t) {
        // no-op by default.
    }
}