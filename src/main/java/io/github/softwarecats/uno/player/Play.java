package io.github.softwarecats.uno.player;

import io.github.softwarecats.uno.card.base.Card;
import lombok.NonNull;

public record Play(Card cardPlayed, @NonNull PlayerActor player) {

    public static Play of(Card card, PlayerActor player) {
        return new Play(card, player);
    }
}
