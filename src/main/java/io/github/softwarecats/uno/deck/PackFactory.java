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

package io.github.softwarecats.uno.deck;

import io.github.softwarecats.uno.deck.cards.*;

public class PackFactory {

    public static Deck getPack() {
        Deck pack = new Deck();

        // Number cards
        for (Color color : Color.values()) {
            pack.add(new NumberCard(color, 0));
            for (int i = 1; i <= 9; i++) {
                pack.add(new NumberCard(color, i));
                pack.add(new NumberCard(color, i));
            }
        }


        for (Color color : Color.values()) {
            // Skip cards
            pack.add(new SkipCard(color));
            pack.add(new SkipCard(color));

            // Reverse cards
            pack.add(new ReverseCard(color));
            pack.add(new ReverseCard(color));

            // Draw two cards
            pack.add(new DrawTwoCard(color));
            pack.add(new DrawTwoCard(color));
        }

        for (int i = 0; i < 4; i++) {
            // Wild cards
            pack.add(new WildCard());

            // Wild draw four cards
            pack.add(new WildDrawFourCard());
        }

        return pack;
    }
}
