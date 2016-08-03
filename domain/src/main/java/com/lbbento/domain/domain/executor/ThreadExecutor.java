package com.lbbento.domain.domain.executor;

import java.util.concurrent.Executor;

/**
 * Created by lbbento on 3/08/2016.
 * This interface is created in order to not execute jobs on the UI thread.
 */

public interface ThreadExecutor extends Executor {}
