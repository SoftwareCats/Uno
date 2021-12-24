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

package io.github.softwarecats.uno.player.controller;

import io.github.softwarecats.uno.player.PlayerActor;

/**
 * The abstract controller controlling the physical {@link io.github.softwarecats.uno.player.PlayerActor}.
 * <p>
 * Controller data exists across the {@link io.github.softwarecats.uno.game.Game} session.
 */
// TODO: It is the responsibility of the controller to recolor WildCards when they are played.
public abstract class Controller {

    public void onPossess(PlayerActor playerActor) {

    }

    public void onDetach(PlayerActor playerActor) {

    }
}
