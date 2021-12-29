package io.github.softwarecats.uno.card.action;

import io.github.softwarecats.uno.game.Round;
import lombok.*;
import org.jetbrains.annotations.NotNull;

/**
 * Singleton representing an action that has no effect.
 */
@Value
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
public class EmptyAction extends Action {

    /**
     * Static to class instance of the class.
     */
    @Getter
    @NotNull
    private static final EmptyAction instance = new EmptyAction();

    @Override
    public void performAction(Round round) {
        // Empty action has no effect.
    }
}
