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

import io.github.softwarecats.uno.card.WildCard;
import io.github.softwarecats.uno.card.base.Card;
import io.github.softwarecats.uno.player.PlayerActor;
import io.github.softwarecats.uno.player.controller.Controller;
import io.github.softwarecats.uno.util.DeckBuilder;

import java.util.*;

public class Round {

    protected final List<PlayerActor> players = new ArrayList<>();

    protected final Random random;

    protected Deque<Card> drawPile;

    protected Deque<Card> discardPile;

    protected int currentPlayerIndex;

    protected PlayDirection currentPlayDirection;

    public Round(Collection<Controller> controllers) {
        this(controllers, new Random());
    }

    public Round(Collection<Controller> controllers, Random rng) {
        // Initialize the random number generator.
        random = rng;

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

        // Put remaining cards into the draw pile.
        drawPile = new ArrayDeque<>(deck);

        // Turn over the first card of draw pile to start the discard pile.
        // Keep picking until the card is not a WildCard.
        Card selectedCard = drawPile.removeFirst();
        while (selectedCard.getColor().isEmpty()) {
            drawPile.addLast(selectedCard);
            selectedCard = drawPile.removeFirst();
        }
        discardPile.add(selectedCard);

        // Initialize play direction with LEFT.
        currentPlayDirection = PlayDirection.LEFT;

        // Select a random player to start the round.
        currentPlayerIndex = random.nextInt(0, players.size());
    }

    public void simulate() {

    }

    /**
     * Sets the current player index.
     * <p>
     * This method is preferred compared to directly setting the {@link Round#currentPlayerIndex} because it
     * automatically checks for {@link IndexOutOfBoundsException}.
     *
     * @param currentPlayerIndex the new index
     */
    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        if (currentPlayerIndex < 0 || currentPlayerIndex >= players.size()) {
            throw new IndexOutOfBoundsException("Current player index must be within the bounds of the players list.");
        }
        this.currentPlayerIndex = currentPlayerIndex;
    }
}
