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
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
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
        Multiset<Pair<Color, Integer>> numberCardCounts = HashMultiset.create();

        for (Card card : pack) {
            if (card instanceof NumberCard) {
                NumberCard numberCard = (NumberCard) card;
                numberCardCounts.add(new ImmutablePair<>(numberCard.getColor(), numberCard.getNumber()));
            }
        }

        for (Color color : Color.values()) {
            for (int i = 1; i <= 9; i++) {
                Assertions.assertEquals(2, numberCardCounts.count(new ImmutablePair<>(color, i)));
            }
            Assertions.assertEquals(1, numberCardCounts.count(new ImmutablePair<>(color, 0)));
        }

        // Action Cards
        Multiset<Pair<String, Color>> actionCardCounts = HashMultiset.create();

        for (Card card : pack) {
            if (card instanceof ColoredCard) {
                actionCardCounts.add(new ImmutablePair<>(
                        card.getClass().getName(),
                        ((ColoredCard) card).getColor()));
            } else {
                actionCardCounts.add(new ImmutablePair<>(
                        card.getClass().getName(),
                        null));
            }
        }

        for (Color color : Color.values()) {
            Assertions.assertEquals(2, actionCardCounts.count(new ImmutablePair<>(SkipCard.class.getName(), color)));
            Assertions.assertEquals(2, actionCardCounts.count(new ImmutablePair<>(ReverseCard.class.getName(), color)));
            Assertions.assertEquals(2, actionCardCounts.count(new ImmutablePair<>(DrawTwoCard.class.getName(), color)));
        }

        Assertions.assertEquals(4, actionCardCounts.count(new ImmutablePair<String, Color>(WildCard.class.getName(), null)));
        Assertions.assertEquals(4, actionCardCounts.count(new ImmutablePair<String, Color>(WildDrawFourCard.class.getName(), null)));
    }
}