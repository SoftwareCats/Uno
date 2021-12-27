package io.github.softwarecats.uno.card.action;

import io.github.softwarecats.uno.game.Round;

/**
 * Actions are performed at the end of each player's turn. They usually affect the next player in line.
 */
public abstract class Action {

    public abstract void performAction(Round round);

}
