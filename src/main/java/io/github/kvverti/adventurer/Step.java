package io.github.kvverti.adventurer;

import io.github.kvverti.adventurer.direction.TurnAction;

public record Step(TurnAction turn, int distance) {
}
