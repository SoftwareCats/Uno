package io.github.softwarecats.uno.util;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import io.github.softwarecats.uno.card.*;
import io.github.softwarecats.uno.card.base.Card;
import io.github.softwarecats.uno.card.base.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckBuilderTest {

    private Multiset<Card> fullDeck;

    @BeforeEach
    void setUp() {
        fullDeck = HashMultiset.create(DeckBuilder.getDeck());
    }

    @Test
    void getDeck() {
        // Ensure 112 cards in total.
        assertEquals(108, fullDeck.size());

        // Ensure 19 number cards from 0-9 of each color.
        for (Color color : Color.values()) {
            assertEquals(1, fullDeck.count(new NumberCard(color, 0)));
            for (int i = 1; i <= 9; i++) {
                assertEquals(2, fullDeck.count(new NumberCard(color, i)));
            }
        }

        // Ensure 2 action fullDeck per type and color.
        for (Color color : Color.values()) {
            assertEquals(2, fullDeck.count(new DrawTwoCard(color)));
            assertEquals(2, fullDeck.count(new ReverseCard(color)));
            assertEquals(2, fullDeck.count(new SkipCard(color)));
        }

        // Ensure 4 WildCards and 4 WildDrawFourCards.
        assertEquals(4, fullDeck.count(new WildCard()));
        assertEquals(4, fullDeck.count(new WildDrawFourCard()));

        // Ensure WildCards have no predetermined color.
        for (Card card : fullDeck) {
            if (card instanceof WildCard) {
                assertTrue(card.getColor().isEmpty());
            }
        }
    }

    @Test
    void generateWildCards() {
        Multiset<Card> deck = HashMultiset.create();
        DeckBuilder.generateWildCards(deck);
        assertEquals(4, deck.count(new WildCard()));
        assertEquals(4, deck.size());
    }

    @Test
    void generateWildDrawFourCards() {
        Multiset<Card> deck = HashMultiset.create();
        DeckBuilder.generateWildDrawFourCards(deck);
        assertEquals(4, deck.count(new WildDrawFourCard()));
        assertEquals(4, deck.size());
    }

    @Test
    void generateSkipCards() {
        Multiset<Card> deck = HashMultiset.create();
        DeckBuilder.generateSkipCards(deck);
        for (Color color : Color.values()) {
            assertEquals(2, deck.count(new SkipCard(color)));
        }
        assertEquals(8, deck.size());
    }

    @Test
    void generateReverseCards() {
        Multiset<Card> deck = HashMultiset.create();
        DeckBuilder.generateReverseCards(deck);
        for (Color color : Color.values()) {
            assertEquals(2, deck.count(new ReverseCard(color)));
        }
        assertEquals(8, deck.size());
    }

    @Test
    void generateDrawTwoCards() {
        Multiset<Card> deck = HashMultiset.create();
        DeckBuilder.generateDrawTwoCards(deck);
        for (Color color : Color.values()) {
            assertEquals(2, deck.count(new DrawTwoCard(color)));
        }
        assertEquals(8, deck.size());
    }

    @Test
    void generateNumberCards() {
        Multiset<Card> deck = HashMultiset.create();
        DeckBuilder.generateNumberCards(deck);
        for (Color color : Color.values()) {
            assertEquals(1, deck.count(new NumberCard(color, 0)));
            for (int i = 1; i <= 9; i++) {
                assertEquals(2, deck.count(new NumberCard(color, i)));
            }
        }
        assertEquals(76, deck.size());
    }
}
