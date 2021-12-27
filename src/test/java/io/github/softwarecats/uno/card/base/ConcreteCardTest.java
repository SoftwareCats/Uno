package io.github.softwarecats.uno.card.base;

import io.github.softwarecats.uno.card.DrawTwoCard;
import io.github.softwarecats.uno.card.NumberCard;
import io.github.softwarecats.uno.card.WildCard;
import io.github.softwarecats.uno.card.action.Action;
import io.github.softwarecats.uno.card.action.EmptyAction;
import lombok.NonNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ConcreteCardTest {

    protected ConcreteCard concreteCard;

    @BeforeEach
    void setUp() {
        concreteCard = new ConcreteCard(Color.RED) {
            @Override
            public Optional<String> getFaceValue() {
                return Optional.of("TestFaceValue");
            }

            @Override
            public @NonNull Action getAction() {
                return EmptyAction.getInstance();
            }

            @Override
            public int pointValue() {
                return 0;
            }
        };
    }

    @Test
    void getColor() {
        assertEquals(Color.RED, concreteCard.getColor().orElse(null));
    }

    @Test
    void canPlaceOn() {
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
            Mockito.when(mockCard.getFaceValue()).thenReturn(Optional.of("TestFaceValue"));
            Mockito.when(mockCard.getColor()).thenReturn(Optional.of(color));

            assertTrue(concreteCard.canPlaceOn(mockCard));
        }

        // Error should be thrown if the other card has no valid FaceValue or Color.
        WildCard mockWildCard = Mockito.mock(WildCard.class);
        Mockito.when(mockWildCard.getColor()).thenReturn(Optional.empty());
        Mockito.when(mockWildCard.getFaceValue()).thenReturn(Optional.of("WildCard"));
        assertThrows(IllegalArgumentException.class, () -> concreteCard.canPlaceOn(mockWildCard));

        for (Color color : Color.values()) {
            Card mockCard = Mockito.mock(Card.class);
            Mockito.when(mockCard.getColor()).thenReturn(Optional.of(color));
            Mockito.when(mockCard.getFaceValue()).thenReturn(Optional.empty());
            assertThrows(IllegalArgumentException.class, () -> concreteCard.canPlaceOn(mockWildCard));
        }
    }
}
