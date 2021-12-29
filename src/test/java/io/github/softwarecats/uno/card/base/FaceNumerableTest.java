package io.github.softwarecats.uno.card.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FaceNumerableTest {

    protected FaceNumerable numerable;

    @Test
    void getFaceValue() {
        for (int i = 0; i < 10; i++) {
            final int finalI = i;
            numerable = new FaceNumerable() {
                @Override
                public int getFaceNumber() {
                    return finalI;
                }
            };

            assertEquals(String.valueOf(i), numerable.getFaceValue());
        }
    }
}
