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

package io.github.softwarecats.uno.agent;

import io.github.softwarecats.uno.deck.Deck;
import io.github.softwarecats.uno.deck.cards.Card;
import io.github.softwarecats.uno.game.Round;
import org.jetbrains.annotations.NotNull;

public abstract class Player {

    protected int points = 0;

    protected Deck hand = new Deck();

    public abstract @NotNull
    Play play(Round round);

    public abstract @NotNull
    Play playAfterDrawing(Round round, Card cardDrawn);

    public abstract void newRound();

    public Deck getHand() {
        return hand;
    }

    public int getPoints() {
        return points;
    }
}
