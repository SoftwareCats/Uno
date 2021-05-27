package io.github.softwarecats.uno.deck;

import io.github.softwarecats.uno.Game;
import io.github.softwarecats.uno.agent.Play;

public class WildCard extends Card {

    @Override
    public void performAction(Game game, Play play) {
        game.setCurrentColor(play.getNewColor());
    }
}
