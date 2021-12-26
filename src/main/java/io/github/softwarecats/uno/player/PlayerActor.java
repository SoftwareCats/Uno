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

package io.github.softwarecats.uno.player;

import io.github.softwarecats.uno.card.base.Card;
import io.github.softwarecats.uno.player.controller.Controller;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.tuple.Pair;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * The physical embodiment of an actor participating in a {@link io.github.softwarecats.uno.game.Game}.
 * <p>
 * Player data only exists across a single {@link io.github.softwarecats.uno.game.Round}.
 */
// TODO: Implement PropertyChangeSupport on the game
public class PlayerActor implements PropertyChangeListener {

    protected Controller controller;

    @Getter
    protected final List<Card> hand;

    public PlayerActor(Controller controller, Collection<Card> hand) {
        this.controller = controller;
        controller.onPossess(this);
        this.hand = new ArrayList<>(hand);
    }

    public PlayerActor(Controller controller) {
        this(controller, new ArrayList<>());
    }

    /**
     * Called when the player will not be used by the game again and is effectively destroyed.
     */
    public void onDestroy() {
        controller.onDetach(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        controller.onPropertyChange(this, evt);
    }

    /**
     * Called when it is the player's turn to play a card.
     * <p>
     * If the player wishes to renege they should return an empty {@link Play} instead of null.
     *
     * @return the card to play
     */
    public Play play() {
        return controller.onPlay(this);
    }

    /**
     * Called when the player has a chance to play the card they just drew by reneging.
     *
     * @return the card to play
     */
    public Play renegingPlay(Pair<Card, Card> cardsDrawn) {
        return controller.onRenegingPlay(this, cardsDrawn);
    }
}
