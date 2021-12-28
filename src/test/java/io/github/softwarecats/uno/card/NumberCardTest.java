package io.github.softwarecats.uno.card;

import io.github.softwarecats.uno.card.action.EmptyAction;
import io.github.softwarecats.uno.card.base.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberCardTest {

    protected NumberCard redOne;

    @BeforeEach
    void setUp() {
        redOne = new NumberCard(Color.RED, 1);
    }

    @Test
    void getAction() {
        // Number card has no action.
        assertEquals(EmptyAction.getInstance(), redOne.getAction());
    }

    @Test
    void pointValue() {
        for (int i = 0; i <= 9; i++) {
            for (Color color : Color.values()) {
                NumberCard currentCard = new NumberCard(color, i);
                assertEquals(i, currentCard.pointValue());
            }
        }
    }

    @Test
    void getFaceNumber() {
        for (int i = 0; i <= 9; i++) {
            for (Color color : Color.values()) {
                NumberCard currentCard = new NumberCard(color, i);
                assertEquals(i, currentCard.getFaceNumber());
            }
        }
    }

    @Test
    void getFaceValue() {
        for (int i = 0; i <= 9; i++) {
            for (Color color : Color.values()) {
                NumberCard currentCard = new NumberCard(color, i);
                assertEquals(String.valueOf(i), currentCard.getFaceValue());
            }
        }
    }
}
