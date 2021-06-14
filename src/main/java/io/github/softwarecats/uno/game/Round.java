/*
 * Copyright © Bowen Wu 2021
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

package io.github.softwarecats.uno.game;

import io.github.softwarecats.uno.agent.Play;
import io.github.softwarecats.uno.agent.Player;
import io.github.softwarecats.uno.deck.Deck;
import io.github.softwarecats.uno.deck.DiscardPile;
import io.github.softwarecats.uno.deck.cards.Card;
import io.github.softwarecats.uno.deck.cards.NullCard;
import io.github.softwarecats.uno.deck.cards.WildCard;
import io.github.softwarecats.uno.deck.event.Event;
import io.github.softwarecats.uno.util.CardDealer;
import io.github.softwarecats.uno.util.PlayerPicker;
import io.github.softwarecats.uno.util.Validator;
import io.github.softwarecats.uno.util.WinChecker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Round {

    protected final List<Player> players;

    protected Deck drawPile;
    protected DiscardPile discardPile;

    protected Direction currentDirection = Rules.INITIAL_DIRECTION;

    protected Player currentPlayer;
    protected List<Event> events = new ArrayList<>();

    public Round(List<Player> players) {
        this.players = players;
        setUp();
    }

    protected void setUp() {
        drawPile = CardDealer.dealCards(Game.PACK, players, Rules.INITIAL_CARD_COUNT);

        Card firstCard;
        do {
            firstCard = CardDealer.randomCard(drawPile);
        } while (firstCard instanceof WildCard);
        drawPile.remove(firstCard);
        discardPile = new DiscardPile(firstCard);

        currentPlayer = PlayerPicker.pickPlayer(players);
    }

    protected void turn() {
        // Trigger events from last turn
        for (Event event : events) {
            switch (event) {
                case DRAW_TWO:
                    for (int i = 0; i < 2; i++) {
                        currentPlayer.getHand().add(drawCard());
                    }
                    break;
                case DRAW_FOUR:
                    for (int i = 0; i < 4; i++) {
                        currentPlayer.getHand().add(drawCard());
                    }
                    break;
                case SKIP:
                    currentPlayer = currentDirection.getNextPlayer(players, currentPlayer);
                    events.clear();
                    return;
            }
        }
        events.clear();

        // Let player play a card
        Play play = currentPlayer.play(this);

        // Validate play
        if (!Validator.isValidPlay(this, play)) {
            // If play is invalid, we assume the player plays null
            play = NullCard.getInstance().getPlay(currentPlayer);
        }

        // If not passing turn, perform card action
        if (!(play.getCard() instanceof NullCard)) {
            // Remove card from player's hand
            currentPlayer.getHand().remove(play.getCard());

            // Place card on discard pile
            discardPile.add(play.getCard());

            // Perform card action
            // This also updates the current color (card action includes updating the color)
            play.getCard().performAction(this, play);
        } else { // If player is passing turn, draw card
            Card cardDrawn = drawCard();

            // Ask player if they want to play the card they drew
            play = currentPlayer.playAfterDrawing(this, cardDrawn);

            // Validate play
            if (!Validator.isValidPlayAfterDrawing(this, cardDrawn, play)) {
                // If play is invalid, we assume the player does not play the card they just drew
                play = NullCard.getInstance().getPlay(currentPlayer);
            }

            // If playing the card they just drew, perform card action
            if (!(play.getCard() instanceof NullCard)) {
                // Place card on discard pile
                discardPile.add(play.getCard());

                // Perform card action
                // This also updates the current color (card action includes updating the color)
                play.getCard().performAction(this, play);
            } else { // if not playing the card, add card to player's hand
                currentPlayer.getHand().add(cardDrawn);
            }
        }

        currentPlayer = currentDirection.getNextPlayer(players, currentPlayer);
    }

    protected Card drawCard() {
        // If draw pile is empty, shuffle discard pile to become draw pile
        if (drawPile.size() == 0) {
            Deck newDrawPile = new Deck(discardPile);
            Collections.shuffle(newDrawPile);
            drawPile = newDrawPile;

            // Get the first card of the draw pile as the start of the discard pile
            Card firstCard;
            do {
                firstCard = CardDealer.randomCard(drawPile);
            } while (firstCard instanceof WildCard);
            drawPile.remove(firstCard);
            discardPile = new DiscardPile(firstCard);
        }

        // Draw card
        Card cardDrawn = CardDealer.randomCard(drawPile);
        drawPile.remove(cardDrawn);

        return cardDrawn;
    }

    public void simulate() {
        while (WinChecker.playerWonRound(players) == null) {
            turn();
        }
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void registerEvent(Event event) {
        events.add(event);
    }
}
