package io.github.softwarecats.uno.util;

import io.github.softwarecats.uno.card.*;
import io.github.softwarecats.uno.card.base.Card;
import io.github.softwarecats.uno.card.base.Color;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DeckBuilder {

    private DeckBuilder() {
    }

    public static @NonNull List<Card> getDeck() {
        List<Card> deck = new ArrayList<>();

        // Number cards.
        generateNumberCards(deck);

        // Action cards.
        generateSkipCards(deck);
        generateReverseCards(deck);
        generateDrawTwoCards(deck);

        // Wild cards.
        generateWildCards(deck);
        generateWildDrawFourCards(deck);

        return deck;
    }

    protected static void generateWildCards(Collection<Card> deck) {
        for (int i = 0; i < 4; i++) {
            deck.add(new WildCard());
        }
    }

    protected static void generateWildDrawFourCards(Collection<Card> deck) {
        for (int i = 0; i < 4; i++) {
            deck.add(new WildDrawFourCard());
        }
    }

    protected static void generateSkipCards(Collection<Card> deck) {
        // Two skip cards for each color.
        for (Color color : Color.values()) {
            for (int i = 0; i < 2; i++) {
                deck.add(new SkipCard(color));
            }
        }
    }

    protected static void generateReverseCards(Collection<Card> deck) {
        // Two reverse cards for each color.
        for (Color color : Color.values()) {
            for (int i = 0; i < 2; i++) {
                deck.add(new ReverseCard(color));
            }
        }
    }

    protected static void generateDrawTwoCards(Collection<Card> deck) {
        // Two draw two cards for each color.
        for (Color color : Color.values()) {
            for (int i = 0; i < 2; i++) {
                deck.add(new DrawTwoCard(color));
            }
        }
    }

    protected static void generateNumberCards(Collection<Card> deck) {
        for (Color color : Color.values()) {
            // Only 1 zero card for each color.
            deck.add(new NumberCard(color, 0));

            // Two cards for other numbers.
            for (int i = 1; i <= 9; i++) {
                for (int j = 0; j < 2; j++) {
                    deck.add(new NumberCard(color, i));
                }
            }
        }
    }
}
