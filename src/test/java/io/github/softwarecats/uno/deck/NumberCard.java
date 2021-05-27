package io.github.softwarecats.uno.deck;

import io.github.softwarecats.uno.Game;
import io.github.softwarecats.uno.agent.Play;

public class NumberCard extends ColoredCard {

    protected int number;

    public NumberCard(Color color, int number) {
        super(color);
        this.number = number;
    }

    @Override
    public void performAction(Game game, Play play) {
        // Number cards have no action
    }
}
