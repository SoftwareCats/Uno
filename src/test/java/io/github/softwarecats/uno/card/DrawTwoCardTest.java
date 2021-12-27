package io.github.softwarecats.uno.card;

import io.github.softwarecats.uno.card.base.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrawTwoCardTest {

    protected DrawTwoCard drawTwoCard;

    @BeforeEach
    void setUp() {
        drawTwoCard = new DrawTwoCard(Color.RED);
    }

    @Test
    void getFaceValue() {
        assertEquals("DrawTwoCard", drawTwoCard.getFaceValue().orElseThrow());
    }

    @Test
    void getAction() {
        // TODO: Implement action processing in game and test here.
    }
}
