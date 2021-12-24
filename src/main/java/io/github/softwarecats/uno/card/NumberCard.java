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

package io.github.softwarecats.uno.card;

import io.github.softwarecats.uno.card.base.Card;
import io.github.softwarecats.uno.card.base.Color;
import io.github.softwarecats.uno.card.base.ConcreteCard;
import org.apache.commons.lang3.NotImplementedException;

import java.util.Optional;

public class NumberCard extends ConcreteCard {

    protected final int number;

    public NumberCard(Color color, int number) {
        super(color);
        this.number = number;
    }

    @Override
    public boolean canPlaceOn(Card card) {
        throw new NotImplementedException();
    }

    @Override
    public void performAction() {
    }

    @Override
    public int pointValue() {
        return number;
    }

    @Override
    public Optional<String> getFaceValue() {
        return Optional.of(String.valueOf(number));
    }
}
