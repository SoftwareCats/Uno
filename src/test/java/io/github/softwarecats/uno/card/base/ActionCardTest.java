package io.github.softwarecats.uno.card.base;

import io.github.softwarecats.uno.card.action.Action;
import io.github.softwarecats.uno.card.action.EmptyAction;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ActionCardTest extends ConcreteCardTest {

    @Override
    @BeforeEach
    protected void setUp() {
        concreteCard = new ActionCard(Color.RED) {
            @Override
            public @NotNull String getFaceValue() {
                return "TestFaceValue";
            }

            @Override
            public @NotNull Action getAction() {
                return EmptyAction.getInstance();
            }
        };
    }

    @Test
    protected void pointValue() {
        assertEquals(20, concreteCard.pointValue());
    }

    @Test
    @Override
    protected void testEquals() {
        // Reflexivity: x equals x
        assertEquals(concreteCard, concreteCard);

        // Symmetry: x.equals(y) must return the same result as y.equals(x)
        ActionCard equalActionCard = new ActionCard(Color.RED) {
            @Override
            public @NotNull String getFaceValue() {
                return "";
            }

            @Override
            public @NotNull Action getAction() {
                return EmptyAction.getInstance();
            }
        };

        ActionCard unequalActionCard = new ActionCard(Color.BLUE) {
            @Override
            public @NotNull String getFaceValue() {
                return "";
            }

            @Override
            public @NotNull Action getAction() {
                return EmptyAction.getInstance();
            }
        };

        assertEquals(concreteCard.equals(equalActionCard), equalActionCard.equals(concreteCard));
        assertEquals(concreteCard.equals(unequalActionCard), unequalActionCard.equals(concreteCard));

        // Transitivity: if x.equals(y) and y.equals(z) then also x.equals(z)
        ActionCard y = new ActionCard(Color.RED) {
            @Override
            public @NotNull String getFaceValue() {
                return "";
            }

            @Override
            public @NotNull Action getAction() {
                return EmptyAction.getInstance();
            }
        };

        ActionCard z = new ActionCard(Color.RED) {
            @Override
            public @NotNull String getFaceValue() {
                return "";
            }

            @Override
            public @NotNull Action getAction() {
                return EmptyAction.getInstance();
            }
        };

        assertEquals(concreteCard, y);
        assertEquals(y, z);
        assertEquals(concreteCard, z);
    }

    @Test
    @Override
    protected void testHashCode() {
        ActionCard equalActionCard = new ActionCard(Color.RED) {
            @Override
            public @NotNull String getFaceValue() {
                return "";
            }

            @Override
            public @NotNull Action getAction() {
                return EmptyAction.getInstance();
            }
        };

        assertEquals(equalActionCard.hashCode(), concreteCard.hashCode());
    }
}
