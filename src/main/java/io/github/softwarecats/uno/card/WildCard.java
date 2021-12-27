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

import io.github.softwarecats.uno.card.action.Action;
import io.github.softwarecats.uno.card.action.EmptyAction;
import io.github.softwarecats.uno.card.base.Card;
import io.github.softwarecats.uno.card.base.Color;
import lombok.NonNull;
import lombok.Setter;

import java.util.Optional;

/**
 * Non-{@link io.github.softwarecats.uno.card.base.ConcreteCard} with a variable {@link Color}.
 */
// TODO: Clear wildcard color as it goes into the draw pile.
public class WildCard extends Card {

    @Setter
    protected Color currentColor;

    @Override
    public boolean canPlaceOn(@NonNull Card other) {
        return true;
    }

    public WildCard() {
    }

    @Override
    public @NonNull Action getAction() {
        // WildCard has no action.
        return EmptyAction.getInstance();
    }

    @Override
    public int pointValue() {
        return 50;
    }

    @Override
    public Optional<Color> getColor() {
        return Optional.ofNullable(currentColor);
    }

    @Override
    public Optional<String> getFaceValue() {
        return Optional.of(getClass().getSimpleName());
    }
}
