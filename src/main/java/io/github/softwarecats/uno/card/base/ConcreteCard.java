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

package io.github.softwarecats.uno.card.base;

import io.github.softwarecats.uno.card.WildCard;
import lombok.EqualsAndHashCode;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

/**
 * Non-{@link WildCard} with a predetermined {@link Color} and FaceValue.
 */
@EqualsAndHashCode(callSuper = true)
public abstract class ConcreteCard extends Card {

    @NotNull
    protected final Color color;

    protected ConcreteCard(@NotNull Color color) {
        this.color = color;
    }

    @Override
    public Optional<Color> getColor() {
        return Optional.of(color);
    }

    @Override
    public boolean canPlaceOn(@NotNull Card other) {
        // Validate color.
        if (other.getColor().isEmpty()) {
            throw new IllegalArgumentException("A WildCard must have a valid color when it is played.");
        }

        // Check color equality.
        if (other.getColor().get() == color) {
            return true;
        }

        // Validate FaceValue.
        if (other.getFaceValue().isEmpty()) {
            throw new IllegalArgumentException("All cards must have a valid FaceValue.");
        }

        if (getFaceValue().isEmpty()) {
            throw new IllegalArgumentException("All cards must have a valid FaceValue.");
        }

        // Check FaceValue equality.
        // We already know the cards don't match in color.
        // Therefore, the card is illegal if it does not match in FaceValue and vice versa.
        return other.getFaceValue().get().equals(getFaceValue().get());
    }
}
