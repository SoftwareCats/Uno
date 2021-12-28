package io.github.softwarecats.uno.player;

import io.github.softwarecats.uno.card.base.Card;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class Play {

    protected final Card cardPlayed;

    @NotNull
    protected final PlayerActor player;

    public static Play of(Card card, PlayerActor player) {
        return new Play(card, player);
    }
}
