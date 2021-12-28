package io.github.softwarecats.uno.player;

import io.github.softwarecats.uno.card.base.Card;
import org.jetbrains.annotations.NotNull;

public record Play(@NotNull PlayerActor player, Card cardPlayed) {

    public static Play of(PlayerActor player, Card card) {
        return new Play(player, card);
    }
}
