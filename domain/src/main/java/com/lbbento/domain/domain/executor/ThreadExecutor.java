/*
 * Copyright (C) 2016 Lucas Bento Open Source Proj.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.lbbento.domain.domain.executor;

import java.util.concurrent.Executor;

/**
 * Created by lbbento on 3/08/2016.
 * This interface is created in order to not execute jobs on the UI thread.
 */

public interface ThreadExecutor extends Executor {}
