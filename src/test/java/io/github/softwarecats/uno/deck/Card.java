package io.github.softwarecats.uno.deck;

import io.github.softwarecats.uno.Game;
import io.github.softwarecats.uno.agent.Play;

public abstract class Card {

    public abstract void performAction(Game game, Play play);

}
