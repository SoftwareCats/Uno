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

import java.util.List;

public enum Direction {
    LEFT(-1),
    RIGHT(1);

    protected int indexShift;

    Direction(int indexShift) {
        this.indexShift = indexShift;
    }

    public Player getNextPlayer(List<Player> players, Player currentPlayer) {
        int currentIndex = players.indexOf(currentPlayer);

        currentIndex += indexShift;

        // If is first or last item, then loop around
        if (currentIndex == -1) {
            currentIndex = players.size() - 1;
        } else if (currentIndex == players.size()) {
            currentIndex = 0;
        }

        return players.get(currentIndex);
    }
}
