package io.github.softwarecats.uno.util;

import io.github.softwarecats.uno.card.*;
import io.github.softwarecats.uno.card.base.Card;
import io.github.softwarecats.uno.card.base.Color;

import java.util.ArrayList;
import java.util.List;

public class DeckBuilder {

    public static List<Card> getDeck() {
        List<Card> deck = new ArrayList<>();

        // Number cards.
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

        // Action cards.
        for (Color color : Color.values()) {
            for (int i = 0; i < 8; i++) {
                deck.add(new SkipCard(color));
                deck.add(new ReverseCard(color));
                deck.add(new DrawTwoCard(color));
            }
        }

        // Wildcards.
        for (int i = 0; i < 4; i++) {
            deck.add(new WildCard());
            deck.add(new WildDrawFourCard());
        }

        return deck;
    }
}
