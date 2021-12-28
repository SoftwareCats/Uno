package io.github.softwarecats.uno.player;

import io.github.softwarecats.uno.card.base.Card;
import org.jetbrains.annotations.NotNull;

public record Play(Card cardPlayed, @NotNull PlayerActor player) {

    public static Play of(Card card, PlayerActor player) {
        return new Play(card, player);
    }
}
