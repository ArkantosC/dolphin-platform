/**
 * Copyright 2015-2016 Canoo Engineering AG.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.canoo.dolphin.client.impl;

import com.canoo.dolphin.util.Assert;
import org.opendolphin.core.client.ClientDolphin;

import java.util.concurrent.CompletableFuture;

public class DolphinCommandHandler {
    private final ClientDolphin clientDolphin;

    public DolphinCommandHandler(ClientDolphin clientDolphin) {
        Assert.requireNonNull(clientDolphin, "clientDolphin");
        this.clientDolphin = clientDolphin;
    }

    public CompletableFuture<Void> invokeDolphinCommand(String command) {
        Assert.requireNonNull(command, "command");
        final CompletableFuture<Void> result = new CompletableFuture<>();
        clientDolphin.send(command, presentationModels -> result.complete(null));
        return result;
    }
}
