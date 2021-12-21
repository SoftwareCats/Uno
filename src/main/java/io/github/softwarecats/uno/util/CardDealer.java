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

package io.github.softwarecats.uno.util;

import io.github.softwarecats.uno.agent.Player;
import io.github.softwarecats.uno.deck.Deck;
import io.github.softwarecats.uno.deck.cards.Card;

import java.util.List;
import java.util.Random;

public class CardDealer {

    protected static final Random RNG = new Random();

    public static Card randomCard(Deck deck) {
        return deck.get(RNG.nextInt(deck.size()));
    }

    /**
     * Deals cards to players.
     *
     * @param pack          the complete pack of cards
     * @param players       the players for the cards to be dealt to
     * @param numberOfCards how many cards to deal to each player
     * @return the leftover cards not dealt to players
     */
    public static Deck dealCards(Deck pack, List<Player> players, int numberOfCards) {
        Deck deck = new Deck(pack);

        for (Player player : players) {
            for (int i = 0; i < numberOfCards; i++) {
                Card drawnCard = randomCard(deck);
                player.getHand().add(drawnCard);
                deck.remove(drawnCard);
            }
        }

        return deck;
    }
}
