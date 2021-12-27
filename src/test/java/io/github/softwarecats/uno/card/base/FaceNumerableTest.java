package io.github.softwarecats.uno.card.base;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class FaceNumerableTest {
    
    protected FaceNumerable illegalNumerable;
    private FaceNumerable legalNumerable;

    @BeforeEach
    void setUp() {
        illegalNumerable = new FaceNumerable() {
            @Override
            public Optional<Integer> getFaceNumber() {
                return Optional.empty();
            }
        };

        legalNumerable = new FaceNumerable() {
            @Override
            public Optional<Integer> getFaceNumber() {
                return Optional.of(1);
            }
        };
    }

    @Test
    void getFaceValue() {
        assertTrue(illegalNumerable.getFaceValue().isEmpty());
        assertEquals("1", legalNumerable.getFaceValue().orElseThrow());
    }
}
