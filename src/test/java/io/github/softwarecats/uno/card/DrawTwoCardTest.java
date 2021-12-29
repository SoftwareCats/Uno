package io.github.softwarecats.uno.card;

import io.github.softwarecats.uno.card.base.ActionCardTest;
import io.github.softwarecats.uno.card.base.Card;
import io.github.softwarecats.uno.card.base.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class DrawTwoCardTest extends ActionCardTest {

    @Override
    @BeforeEach
    protected void setUp() {
        concreteCard = new DrawTwoCard(Color.RED);
    }

    @Test
    protected void getFaceValue() {
        assertEquals("DrawTwo", concreteCard.getFaceValue());
    }

    @Override
    @Test
    protected void canPlaceOn() {
        // The placement test should return true for any face value if color is same.
        for (int i = 0; i <= 9; i++) {
            assertTrue(concreteCard.canPlaceOn(new NumberCard(Color.RED, i)));
        }

        // The placement test should return false if color and face value are different.
        for (int i = 0; i <= 9; i++) {
            for (Color color : List.of(Color.YELLOW, Color.GREEN, Color.BLUE)) {
                assertFalse(concreteCard.canPlaceOn(new NumberCard(color, i)));
            }
        }

        // The placement test should return true for any color if face value is the same.
        for (Color color : Color.values()) {
            DrawTwoCard mockCard = Mockito.mock(DrawTwoCard.class);
            Mockito.when(mockCard.getFaceValue()).thenReturn("DrawTwo");
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

    @Test
    protected void getAction() {
        // TODO: Implement action processing in game and test here.
    }

    @Override
    @Test
    protected void testEquals() {
        // Reflexivity: x equals x
        assertEquals(concreteCard, concreteCard);

        // Symmetry: x.equals(y) must return the same result as y.equals(x)
        DrawTwoCard equalDrawTwoCard = new DrawTwoCard(Color.RED);
        DrawTwoCard unequalDrawTwoCard = new DrawTwoCard(Color.BLUE);

        assertEquals(concreteCard.equals(equalDrawTwoCard), equalDrawTwoCard.equals(concreteCard));
        assertEquals(concreteCard.equals(unequalDrawTwoCard), unequalDrawTwoCard.equals(concreteCard));

        // Transitivity: if x.equals(y) and y.equals(z) then also x.equals(z)
        DrawTwoCard y = new DrawTwoCard(Color.RED);
        DrawTwoCard z = new DrawTwoCard(Color.RED);

        assertEquals(concreteCard, y);
        assertEquals(y, z);
        assertEquals(concreteCard, z);
    }

    @Override
    @Test
    protected void testHashCode() {
        DrawTwoCard equalDrawTwoCard = new DrawTwoCard(Color.RED);

        assertEquals(equalDrawTwoCard.hashCode(), concreteCard.hashCode());
    }
}
