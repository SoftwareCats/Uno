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

package io.github.softwarecats.uno.util;

import io.github.softwarecats.uno.agent.Play;
import io.github.softwarecats.uno.deck.DiscardPile;
import io.github.softwarecats.uno.deck.cards.*;
import io.github.softwarecats.uno.game.Round;
import org.apache.commons.lang3.NotImplementedException;

public class Validator {

    // TODO: Finish validate method, this current one is a stub
    public static boolean isValidPlay(Round round, Play play) {
        // Get relevant cards.
        Card topCard = round.getDiscardPile().getTopCard();
        Card playedCard = play.getCard();

        // Wild cards are valid unless no new color is provided.
        if (playedCard instanceof WildCard) {
            return play.getNewColor() != null;
        }

        // Initialize equality recorders.
        boolean equalWord = false;
        boolean equalColor = false;

        // Equal number
        if (topCard instanceof NumberCard && playedCard instanceof NumberCard) {
            if (((NumberCard) playedCard).getNumber() == ((NumberCard) topCard).getNumber()) {
                equalWord = true;
            }
        }
        // Equal word
        else if (topCard instanceof SkipCard) {
            if (playedCard instanceof SkipCard) {
                equalWord = true;
            }
        } else if (topCard instanceof ReverseCard) {
            if (playedCard instanceof ReverseCard) {
                equalWord = true;
            }
        } else if (topCard instanceof DrawTwoCard) {
            if (playedCard instanceof DrawTwoCard) {
                equalWord = true;
            }
        }

        // Equal color
        if (topCard instanceof ColoredCard && playedCard instanceof ColoredCard) {
            if (((ColoredCard) topCard).getColor() == ((ColoredCard) playedCard).getColor()) {
                equalColor = true;
            }
        }

        // Combine equality tests for the final verdict.
        return equalWord || equalColor;
    }

    public static boolean isValidPlayAfterDrawing(Round round, Card cardDrawn, Play play) {
        // Make sure the player is playing the card they just drew.
        boolean correctCardPlayed = cardDrawn == play.getCard();

        // Run all other validity tests.
        boolean isValidPlay = isValidPlay(round, play);

        // Combine validity tests for teh final verdict.
        return correctCardPlayed && isValidPlay;
    }

    public static boolean isValidCardAddition(DiscardPile discardPile, Card card) {
        throw new NotImplementedException();
    }
}
