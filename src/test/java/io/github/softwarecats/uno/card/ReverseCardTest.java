package io.github.softwarecats.uno.card;

import io.github.softwarecats.uno.card.base.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseCardTest {

    protected ReverseCard reverseCard;

    @BeforeEach
    void setUp() {
        reverseCard = new ReverseCard(Color.RED);
    }

    @Test
    void getFaceValue() {
        assertEquals("Reverse", reverseCard.getFaceValue());
    }

    @Test
    void getAction() {
        // TODO: Implement action processing in game and test here.
    }
}
