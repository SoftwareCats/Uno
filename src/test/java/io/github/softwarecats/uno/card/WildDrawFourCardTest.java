package io.github.softwarecats.uno.card;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WildDrawFourCardTest {

    WildDrawFourCard wdfCard;

    @BeforeEach
    void setUp() {
        wdfCard = new WildDrawFourCard();
    }

    @Test
    void getFaceValue() {
        assertEquals("WildDrawFour", wdfCard.getFaceValue());
    }

    @Test
    void getAction() {
        // TODO: Implement action processing in game and test here.
    }
}
