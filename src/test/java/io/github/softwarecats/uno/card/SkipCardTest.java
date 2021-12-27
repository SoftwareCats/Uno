package io.github.softwarecats.uno.card;

import io.github.softwarecats.uno.card.base.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SkipCardTest {

    protected SkipCard skipCard;

    @BeforeEach
    void setUp() {
        skipCard = new SkipCard(Color.RED);
    }

    @Test
    void getFaceValue() {
        assertEquals("SkipCard", skipCard.getFaceValue().orElseThrow());
    }

    @Test
    void getAction() {
        // TODO: Implement action processing in game and test here.
    }
}
