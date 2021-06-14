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

package io.github.softwarecats.uno.deck.cards;

import io.github.softwarecats.uno.agent.Play;
import io.github.softwarecats.uno.agent.Player;
import io.github.softwarecats.uno.deck.Color;
import io.github.softwarecats.uno.game.Round;

public class WildCard extends Card {

    protected Color designatedColor;

    public Color getDesignatedColor() {
        return designatedColor;
    }

    @Override
    public void performAction(Round round, Play play) {
        designatedColor = play.getNewColor();
    }

    @Override
    public Play getPlay(Player player) {
        return this.getPlay(player, null);
    }

    public Play getPlay(Player player, Color colorChange) {
        return new Play(this, player, colorChange);
    }
}
