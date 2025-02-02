package io.github.kvverti.adventurer;

import io.github.kvverti.adventurer.direction.TurnAction;
import org.jetbrains.annotations.NotNull;

public record Step(@NotNull TurnAction turn, int distance) {
}
