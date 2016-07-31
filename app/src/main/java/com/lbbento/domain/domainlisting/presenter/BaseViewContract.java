package com.lbbento.domain.domainlisting.presenter;


/**
 * Created by lbbento on 30/07/2016.
 */


public interface BaseViewContract<T>  {

    void setLoadingIndicator(boolean active);

    void setRetryIndicator(boolean active);

    void showLoadingError();
}