package io.github.softwarecats.uno.card.base;

import java.util.Optional;

public interface FaceNumerable extends FaceValuable {

    Optional<Integer> getFaceNumber();

    @Override
    default Optional<String> getFaceValue(){
        if (getFaceNumber().isPresent()) {
            return Optional.of(String.valueOf(getFaceNumber().get()));
        } else {
            return Optional.empty();
        }
    }
}
