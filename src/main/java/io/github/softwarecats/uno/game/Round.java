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

import io.github.softwarecats.uno.card.base.Card;
import io.github.softwarecats.uno.player.PlayerActor;
import io.github.softwarecats.uno.player.controller.Controller;
import io.github.softwarecats.uno.util.DeckBuilder;

import java.util.*;

public class Round {

    protected final List<PlayerActor> players = new ArrayList<>();

    protected Deque<Card> drawPile;

    protected Deque<Card> discardPile;

    public Round(Collection<Controller> controllers) {
        // Create players and deal 7 cards to them.
        List<Card> deck = DeckBuilder.getDeck();
        Collections.shuffle(deck);
        {
            int i = 0;
            for (Controller controller : controllers) {
                List<Card> currentHand = deck.subList(7 * i, 7 * (i + 1));
                deck.removeAll(currentHand);
                PlayerActor currentPlayer = new PlayerActor(controller, currentHand);
                players.add(currentPlayer);
                i++;
            }
        }
    }

    public Round(Controller... controllers) {
        this(List.of(controllers));
    }

    public void simulate() {

    }
}
