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

import io.github.softwarecats.uno.deck.cards.Card;
import io.github.softwarecats.uno.deck.cards.ColoredCard;
import io.github.softwarecats.uno.deck.cards.WildCard;
import io.github.softwarecats.uno.util.Validator;

import java.util.Collection;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class DiscardPile extends Deck {

    public DiscardPile(Card firstCard) {
        super.add(firstCard);
    }

    public Card getTopCard() {
        return this.get(this.size() - 1);
    }

    public Color getCurrentColor() {
        Card topCard = getTopCard();

        if (topCard instanceof WildCard) {
            return ((WildCard) topCard).getDesignatedColor();
        } else {
            return ((ColoredCard) topCard).getColor();
        }
    }

    @Override
    public Card set(int index, Card element) {
        throw new UnsupportedOperationException("Can't change history of discard pile.");
    }

    @Override
    public boolean add(Card card) {
        if (Validator.isValidCardAddition(this, card)) {
            return super.add(card);
        } else {
            throw new UnsupportedOperationException("Can't add card, card is invalid.");
        }
    }

    @Override
    public void add(int index, Card element) {
        throw new UnsupportedOperationException("Can't change history of discard pile.");
    }

    @Override
    public Card remove(int index) {
        throw new UnsupportedOperationException("Can't change history of discard pile.");
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Can't change history of discard pile.");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Can't change history of discard pile.");
    }

    @Override
    public boolean addAll(Collection<? extends Card> c) {
        throw new UnsupportedOperationException("Can't add more than one card to discard pile at once.");
    }

    @Override
    public boolean addAll(int index, Collection<? extends Card> c) {
        throw new UnsupportedOperationException("Can't add more than one card to discard pile at once.");
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Can't change history of discard pile.");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Can't change history of discard pile.");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Can't change history of discard pile.");
    }

    @Override
    public void forEach(Consumer<? super Card> action) {
        throw new UnsupportedOperationException("Can't change history of discard pile.");
    }

    @Override
    public boolean removeIf(Predicate<? super Card> filter) {
        throw new UnsupportedOperationException("Can't change history of discard pile.");
    }

    @Override
    public void replaceAll(UnaryOperator<Card> operator) {
        throw new UnsupportedOperationException("Can't change history of discard pile.");
    }

    @Override
    public void sort(Comparator<? super Card> c) {
        throw new UnsupportedOperationException("Can't change history of discard pile.");
    }
}
