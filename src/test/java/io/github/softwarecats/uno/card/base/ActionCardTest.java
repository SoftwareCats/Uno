package io.github.softwarecats.uno.card.base;

import io.github.softwarecats.uno.card.action.Action;
import io.github.softwarecats.uno.card.action.EmptyAction;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActionCardTest {

    protected ActionCard actionCard;

    @BeforeEach
    void setUp() {
        actionCard = new ActionCard(Color.RED) {
            @Override
            public @NotNull String getFaceValue() {
                return "";
            }

            @Override
            public @NotNull Action getAction() {
                return EmptyAction.getInstance();
            }
        };
    }

    @Test
    void pointValue() {
        assertEquals(20, actionCard.pointValue());
    }
}
