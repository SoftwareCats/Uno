package io.github.softwarecats.uno.player;

import io.github.softwarecats.uno.card.base.Card;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class Play {

    protected final Card cardPlayed;

    @NonNull
    protected final PlayerActor player;

    public static Play of(Card card, PlayerActor player) {
        return new Play(card, player);
    }
}
