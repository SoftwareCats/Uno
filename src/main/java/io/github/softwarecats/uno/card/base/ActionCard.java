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

import java.util.Optional;

public abstract class ActionCard extends ConcreteCard {

    protected ActionCard(Color color) {
        super(color);
    }

    @Override
    public boolean canPlaceOn(Card card) {
        return false;
    }

    @Override
    public void performAction() {

    }

    @Override
    public Optional<String> getFaceValue() {
        return Optional.of(getClass().getSimpleName());
    }
}