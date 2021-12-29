package io.github.softwarecats.uno.card;

import io.github.softwarecats.uno.card.action.EmptyAction;
import io.github.softwarecats.uno.card.base.Card;
import io.github.softwarecats.uno.card.base.Color;
import io.github.softwarecats.uno.card.base.ConcreteCardTest;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class NumberCardTest extends ConcreteCardTest {

    @Override
    @BeforeEach
    protected void setUp() {
        concreteCard = new NumberCard(Color.RED, 1);
    }

    @Test
    protected void getAction() {
        // Number card has no action.
        assertEquals(EmptyAction.getInstance(), concreteCard.getAction());
    }

    @Test
    protected void pointValue() {
        for (int i = 0; i <= 9; i++) {
            for (Color color : Color.values()) {
                NumberCard currentCard = new NumberCard(color, i);
                assertEquals(i, currentCard.pointValue());
            }
        }
    }

    @Test
    protected void getFaceNumber() {
        for (int i = 0; i <= 9; i++) {
            for (Color color : Color.values()) {
                NumberCard currentCard = new NumberCard(color, i);
                assertEquals(i, currentCard.getFaceNumber());
            }
        }
    }

    @Test
    protected void getFaceValue() {
        for (int i = 0; i <= 9; i++) {
            for (Color color : Color.values()) {
                NumberCard currentCard = new NumberCard(color, i);
                assertEquals(String.valueOf(i), currentCard.getFaceValue());
            }
        }
    }

    @Override
    @Test
    protected void canPlaceOn() {
        // The placement test should return true for any face value if color is same.
        assertTrue(concreteCard.canPlaceOn(new DrawTwoCard(Color.RED)));

        // The placement test should return false if color and face value are different.
        for (Color color : List.of(Color.YELLOW, Color.GREEN, Color.BLUE)) {
            assertFalse(concreteCard.canPlaceOn(new DrawTwoCard(color)));
        }

        // The placement test should return true for any color if face value is the same.
        for (Color color : Color.values()) {
            DrawTwoCard mockCard = Mockito.mock(DrawTwoCard.class);
            Mockito.when(mockCard.getFaceValue()).thenReturn("1");
            Mockito.when(mockCard.getColor()).thenReturn(Optional.of(color));

            assertTrue(concreteCard.canPlaceOn(mockCard));
        }

        // Error should be thrown if the other card has no valid FaceValue or Color.
        WildCard mockWildCard = Mockito.mock(WildCard.class);
        Mockito.when(mockWildCard.getColor()).thenReturn(Optional.empty());
        Mockito.when(mockWildCard.getFaceValue()).thenReturn("Wild");
        assertThrows(IllegalArgumentException.class, () -> concreteCard.canPlaceOn(mockWildCard));

        for (Color color : Color.values()) {
            Card mockCard = Mockito.mock(Card.class);
            Mockito.when(mockCard.getColor()).thenReturn(Optional.of(color));
            Mockito.when(mockCard.getFaceValue()).thenReturn("");
            assertThrows(IllegalArgumentException.class, () -> concreteCard.canPlaceOn(mockWildCard));
        }
    }

    @Override
    @Test
    protected void testEquals() {
        // Reflexivity: x equals x
        assertEquals(concreteCard, concreteCard);

        // Symmetry: x.equals(y) must return the same result as y.equals(x)
        NumberCard equalNumberCard = new NumberCard(Color.RED, 1);
        NumberCard unequalNumberCard = new NumberCard(Color.BLUE, 1);

        assertEquals(concreteCard.equals(equalNumberCard), equalNumberCard.equals(concreteCard));
        assertEquals(concreteCard.equals(unequalNumberCard), unequalNumberCard.equals(concreteCard));

        // Transitivity: if x.equals(y) and y.equals(z) then also x.equals(z)
        NumberCard y = new NumberCard(Color.RED, 1);
        NumberCard z = new NumberCard(Color.RED, 1);

        assertEquals(concreteCard, y);
        assertEquals(y, z);
        assertEquals(concreteCard, z);
    }

    @Override
    @Test
    protected void testHashCode() {
        NumberCard equalNumberCard = new NumberCard(Color.RED, 1);

        assertEquals(equalNumberCard.hashCode(), concreteCard.hashCode());
    }
}
