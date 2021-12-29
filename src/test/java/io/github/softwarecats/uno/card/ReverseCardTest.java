package io.github.softwarecats.uno.card;

import io.github.softwarecats.uno.card.action.Action;
import io.github.softwarecats.uno.card.action.EmptyAction;
import io.github.softwarecats.uno.card.base.ActionCardTest;
import io.github.softwarecats.uno.card.base.Card;
import io.github.softwarecats.uno.card.base.Color;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ReverseCardTest extends ActionCardTest {

    @Override
    @BeforeEach
    protected void setUp() {
        concreteCard = new ReverseCard(Color.RED);
    }

    @Test
    protected void getFaceValue() {
        assertEquals("Reverse", concreteCard.getFaceValue());
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
            ReverseCard mockCard = Mockito.mock(ReverseCard.class);
            Mockito.when(mockCard.getFaceValue()).thenReturn("Reverse");
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
        ReverseCard equalReverseCard = new ReverseCard(Color.RED);
        ReverseCard unequalReverseCard = new ReverseCard(Color.BLUE);

        assertEquals(concreteCard.equals(equalReverseCard), equalReverseCard.equals(concreteCard));
        assertEquals(concreteCard.equals(unequalReverseCard), unequalReverseCard.equals(concreteCard));

        // Transitivity: if x.equals(y) and y.equals(z) then also x.equals(z)
        ReverseCard y = new ReverseCard(Color.RED);
        ReverseCard z = new ReverseCard(Color.RED);

        assertEquals(concreteCard, y);
        assertEquals(y, z);
        assertEquals(concreteCard, z);
    }

    @Override
    @Test
    protected void testHashCode() {
        ReverseCard equalReverseCard = new ReverseCard(Color.RED);

        assertEquals(equalReverseCard.hashCode(), concreteCard.hashCode());
    }
}
