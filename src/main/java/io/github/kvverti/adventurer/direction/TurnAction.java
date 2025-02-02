package io.github.kvverti.adventurer.direction;

import org.jetbrains.annotations.NotNull;

/**
 * Actions that modify the facing direction of a path tracer.
 */
public enum TurnAction {
    /**
     * No turn.
     */
    NOT_AT_ALL(0, 'F'),

    /**
     * Left turn (90 degrees counter-clockwise).
     */
    LEFT(1, 'L'),

    /**
     * Right turn (90 degrees clockwise).
     */
    RIGHT(-1, 'R'),

    /**
     * Reverse (180 degrees).
     */
    AROUND(2, 'B');

    /**
     * The offset from a direction in the ordered array of facing directions where the
     * target direction of a turn resides.
     */
    private final int indexOffset;

    /**
     * The unique character that represents this action.
     */
    private final char indicator;

    TurnAction(int indexOffset, char indicator) {
        this.indexOffset = indexOffset;
        this.indicator = indicator;
    }

    /**
     * The unique character that represents this action.
     */
    public char indicator() {
        return this.indicator;
    }

    /**
     * Applies the turn described by this object to the given direction.
     * @param initial the initial facing direction
     * @return the facing direction after applying this turn
     */
    public @NotNull FacingDirection turn(@NotNull FacingDirection initial) {
        var facingDirections = FacingDirection.values();
        var length = facingDirections.length;
        return facingDirections[(initial.ordinal() + this.indexOffset + length) % length];
    }

    /**
     * Parses a turn action given its character indicator.
     * @param indicator the character indicator
     * @return the action the indicator represents
     * @throws IllegalArgumentException if the indicator does not correspond to an action
     */
    public static TurnAction fromIndicator(char indicator) {
        for(var turn : TurnAction.values()) {
            if(turn.indicator() == indicator) {
                return turn;
            }
        }
        throw new IllegalArgumentException(String.valueOf(indicator));
    }
}
