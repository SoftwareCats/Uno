package io.github.softwarecats.uno;

import io.github.softwarecats.uno.agent.Player;
import io.github.softwarecats.uno.deck.Color;
import io.github.softwarecats.uno.deck.Deck;
import io.github.softwarecats.uno.deck.PackFactory;
import java.util.List;

public class Game {

    protected List<Player> players;

    /**
     * The complete deck of all Uno cards.
     */
    protected Deck pack = PackFactory.getPack();

    protected Color currentColor;

    public void setCurrentColor(Color currentColor) {
        this.currentColor = currentColor;
    }

}
