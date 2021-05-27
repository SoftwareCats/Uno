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

import io.github.softwarecats.uno.agent.Player;
import io.github.softwarecats.uno.deck.Color;
import java.util.List;

public class Round {

    protected final List<Player> players;

    protected Color currentColor;
    protected Direction currentDirection;
    protected Player currentPlayer;

    public Round(List<Player> players, Color color, Direction direction) {
        this.players = players;
        this.currentColor = color;
        this.currentDirection = direction;
    }

    public Color getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(Color newColor) {
        this.currentColor = newColor;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

}
