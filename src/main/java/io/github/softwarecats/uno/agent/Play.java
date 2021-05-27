package io.github.softwarecats.uno.agent;

import io.github.softwarecats.uno.deck.Card;
import io.github.softwarecats.uno.deck.Color;

public class Play {

    /**
     * The card to be played
     */
    protected Card card;
    protected Color newColor;

    public Play(Card card) {
        this(card, null);
    }

    public Play(Card card, Color newColor) {
        this.card = card;
        this.newColor = newColor;
    }

    public Color getNewColor() {
        return newColor;
    }
}
