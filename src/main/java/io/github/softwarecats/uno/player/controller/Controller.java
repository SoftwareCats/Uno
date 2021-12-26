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

import io.github.softwarecats.uno.card.base.Card;
import io.github.softwarecats.uno.player.Play;
import io.github.softwarecats.uno.player.PlayerActor;
import org.apache.commons.lang3.tuple.Pair;

import java.beans.PropertyChangeEvent;

/**
 * The abstract controller controlling the physical {@link io.github.softwarecats.uno.player.PlayerActor}.
 * <p>
 * Controller data exists across the {@link io.github.softwarecats.uno.game.Game} session.
 */
// TODO: It is the responsibility of the controller to recolor WildCards when they are played.
public abstract class Controller {

    protected int score;

    public abstract Play onPlay(PlayerActor player);

    public abstract Play onRenegingPlay(PlayerActor player, Pair<Card, Card> cardsDrawn);

    public void onPossess(PlayerActor player) {
    }

    public void onDetach(PlayerActor player) {
    }

    public void onPropertyChange(PlayerActor player, PropertyChangeEvent evt) {
    }
}
