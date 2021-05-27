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

package io.github.softwarecats.uno.agent;

import io.github.softwarecats.uno.deck.Card;
import io.github.softwarecats.uno.deck.Color;
import io.github.softwarecats.uno.deck.WildCard;

public class Play {

    /**
     * The card to be played
     */
    protected final Player player;
    protected final Card card;
    protected Color newColor;

    public Play(WildCard card, Player player, Color newColor) {
        this(card, player);
        this.newColor = newColor;
    }

    public Play(Card card, Player player) {
        this.player = player;
        this.card = card;
    }

    public Player getPlayer() {
        return player;
    }

    public Color getNewColor() {
        return newColor;
    }

    public Card getCard() {
        return card;
    }
}
