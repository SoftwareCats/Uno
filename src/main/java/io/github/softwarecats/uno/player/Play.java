package io.github.softwarecats.uno.player;

import io.github.softwarecats.uno.card.base.Card;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

@Value
@AllArgsConstructor(staticName = "of")
public class Play {

    @Nullable
    Card card;

    @NotNull
    PlayerActor player;

    public Optional<Card> getCard() {
        return Optional.ofNullable(card);
    }
}
