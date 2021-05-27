package io.github.softwarecats.uno.deck;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Deck {

    protected List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
    }

    public Deck(Collection<Card> cards) {
        this.cards = new ArrayList<>(cards);
    }
}
