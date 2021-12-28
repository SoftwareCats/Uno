package io.github.softwarecats.uno.card.base;

import org.jetbrains.annotations.NotNull;

public interface FaceNumerable extends FaceValuable {

    int getFaceNumber();

    @Override
    default @NotNull String getFaceValue(){
        return String.valueOf(getFaceNumber());
    }
}
