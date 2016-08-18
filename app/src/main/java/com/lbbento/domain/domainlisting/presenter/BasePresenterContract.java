package com.lbbento.domain.domainlisting.presenter;

/**
 * Created by lbbento on 30/07/2016.
 */


public interface BasePresenterContract<T> {

    void setView(T view);

    void setLoading(boolean active);

    void setRetry(boolean active);

    void showError();

}