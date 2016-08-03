package com.lbbento.domain.domain.executor;

import rx.Scheduler;

/**
 * Created by lbbento on 3/08/2016.
 * Rx - Change the thread context - update ui
 */

public interface PostExecutionThread {
    Scheduler getScheduler();
}
