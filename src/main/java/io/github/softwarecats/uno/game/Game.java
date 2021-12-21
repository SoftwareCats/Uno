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

import io.github.softwarecats.uno.agent.Player;
import io.github.softwarecats.uno.deck.Deck;
import io.github.softwarecats.uno.deck.PackFactory;
import io.github.softwarecats.uno.util.WinChecker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    /**
     * The complete deck of all Uno cards.
     */
    protected static final Deck PACK = PackFactory.getPack();

    protected final List<Player> players;

    public Game(Collection<Player> players) {
        this.players = new ArrayList<>(players);
    }

    public Game(Player... players) {
        this(Arrays.stream(players).collect(Collectors.toList()));
    }

    protected void playRound() {
        Round currentRound = new Round(players);
        currentRound.simulate();
    }

    public void simulate() {
        while (WinChecker.playerWonGame(players) == null) {
            playRound();

            for (Player player : players) {
                player.getHand().clear();
            }
        }
    }
}
