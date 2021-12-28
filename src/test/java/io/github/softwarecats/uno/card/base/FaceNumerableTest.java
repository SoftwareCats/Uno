package io.github.softwarecats.uno.card.base;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class FaceNumerableTest {
    
    protected FaceNumerable numerable;

    @BeforeEach
    void setUp() {
        numerable = new FaceNumerable() {
            @Override
            public int getFaceNumber() {
                return 1;
            }
        };
    }

    @Test
    void getFaceValue() {
        assertEquals("1", numerable.getFaceValue());
    }
}
