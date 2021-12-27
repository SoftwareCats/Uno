package io.github.softwarecats.uno.card.action;

import io.github.softwarecats.uno.game.Round;

public final class EmptyAction extends Action {

    /**
     * Static to class instance of the class.
     */
    private static final EmptyAction INSTANCE = new EmptyAction();

    /**
     * Private constructor so nobody can instantiate the class.
     */
    private EmptyAction() {
    }

    /**
     * To be called by user to get the only instance of the class.
     *
     * @return instance of the singleton
     */
    public static EmptyAction getInstance() {
        return INSTANCE;
    }

    @Override
    public void performAction(Round round) {
        // Empty action has no effect.
    }
}
