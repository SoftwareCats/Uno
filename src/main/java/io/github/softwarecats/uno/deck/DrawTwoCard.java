package io.github.softwarecats.uno.deck;

import io.github.softwarecats.uno.Game;
import io.github.softwarecats.uno.agent.Play;
import org.apache.commons.lang3.NotImplementedException;

public class DrawTwoCard extends ColoredCard {
    public DrawTwoCard(Color color) {
        super(color);
    }

    @Override
    public void performAction(Game game, Play play) {
        throw new NotImplementedException();
    }
}