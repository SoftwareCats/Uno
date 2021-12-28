package io.github.softwarecats.uno.card;

import io.github.softwarecats.uno.card.action.EmptyAction;
import io.github.softwarecats.uno.card.base.ActionCard;
import io.github.softwarecats.uno.card.base.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WildCardTest {

    protected WildCard wildCard;

    @BeforeEach
    void setUp() {
        wildCard = new WildCard();
    }

    @Test
    void canPlaceOn() {
        // WildCard can be placed on any other card.

        for (Color color : Color.values()) {
            for (int i = 0; i <= 9; i++) {
                NumberCard numberCard = new NumberCard(color, i);
                assertTrue(wildCard.canPlaceOn(numberCard));
            }

            for (ActionCard actionCard : List.of(
                    new DrawTwoCard(color),
                    new ReverseCard(color),
                    new SkipCard(color))) {
                assertTrue(wildCard.canPlaceOn(actionCard));
            }

            WildCard newWildCard = new WildCard();
            assertTrue(wildCard.canPlaceOn(newWildCard));
            newWildCard.setColor(color);
            assertTrue(wildCard.canPlaceOn(newWildCard));
        }
    }

    @Test
    void getAction() {
        // WildCard has no action.
        assertEquals(EmptyAction.getInstance(), wildCard.getAction());
    }

    @Test
    void pointValue() {
        assertEquals(50, wildCard.pointValue());
    }

    @Test
    void getColor() {
        assertTrue(wildCard.getColor().isEmpty());
        for (Color color : Color.values()) {
            wildCard.setColor(color);
            assertEquals(color, wildCard.getColor().orElseThrow());
        }
    }

    @Test
    void getFaceValue() {
        assertEquals("Wild", wildCard.getFaceValue());
    }

    @Test
    void setColor() {
        assertNull(wildCard.currentColor);
        for (Color color : Color.values()) {
            wildCard.setColor(color);
            assertEquals(color, wildCard.currentColor);
        }
    }
}
