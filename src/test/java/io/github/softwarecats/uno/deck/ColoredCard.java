package io.github.softwarecats.uno.deck;

public abstract class ColoredCard extends Card {

    protected Color color;

    public ColoredCard(Color color) {
        this.color = color;
    }
}
