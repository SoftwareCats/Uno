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

package io.github.softwarecats.uno.deck;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import io.github.softwarecats.uno.deck.cards.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PackFactoryTest {

    public Deck pack;

    @BeforeEach
    void setUp() {
        pack = PackFactory.getPack();
    }

    @Test
    void getPack() {
        // Number Cards
        Multiset<Integer> numberCounts = HashMultiset.create();

        for (Card card : pack) {
            if (card instanceof NumberCard) {
                numberCounts.add(((NumberCard) card).getNumber());
            }
        }

        for (int i = 1; i <= 9; i++) {
            Assertions.assertEquals(8, numberCounts.count(i));
        }
        Assertions.assertEquals(4, numberCounts.count(0));

        // Action Cards
        Multiset<Class<? extends Card>> actionCardCounts = HashMultiset.create();

        for (Card card : pack) {
            actionCardCounts.add(card.getClass());
        }

        Assertions.assertEquals(8, actionCardCounts.count(SkipCard.class));
        Assertions.assertEquals(8, actionCardCounts.count(ReverseCard.class));
        Assertions.assertEquals(8, actionCardCounts.count(DrawTwoCard.class));
        Assertions.assertEquals(4, actionCardCounts.count(WildCard.class));
        Assertions.assertEquals(4, actionCardCounts.count(WildDrawFourCard.class));
    }
}