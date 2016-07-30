package com.lbbento.domain.domainlisting.base;


/**
 * Created by lbbento on 30/07/2016.
 */


public interface BaseFragmentContract<T>  {

    void setLoadingIndicator(boolean active);

    void setRetryIndicator(boolean active);

    void showLoadingError();
}