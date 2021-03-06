package io.github.softwarecats.uno.game;

import lombok.Getter;

public enum PlayDirection {
    LEFT(-1),
    RIGHT(1);

    @Getter
    private final int indexChange;

    PlayDirection(int indexChange) {
        this.indexChange = indexChange;
    }

    public PlayDirection getOpposite() {
        switch (this) {
            case LEFT:
                return RIGHT;
            case RIGHT:
                return LEFT;
            default:
                throw new IllegalArgumentException();
        }
    }
}
