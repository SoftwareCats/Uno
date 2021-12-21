/*
 * Copyright © Bowen Wu 2021
 *
 * Licensed under the Apache License, Version 2.0 (the “License”);
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an “AS IS” BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.softwarecats.uno.game;

import io.github.softwarecats.uno.player.controller.Controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Game {

    protected List<Controller> controllers;

    public Game(Collection<Controller> controllers) {
        this.controllers = new ArrayList<>(controllers);
    }

    public Game(Controller... controllers) {
        this(List.of(controllers));
    }

    public void simulate() {

    }
}
