package io.github.kvverti.adventurer.direction;

import org.jetbrains.annotations.NotNull;

/**
 * The possible facing directions of a path tracer.
 * These directions are ordered counterclockwise starting at positive X (east).
 */
public enum FacingDirection {
    /**
     * The positive X direction (east).
     */
    POS_X(Axis.X, +1),

    /**
     * The positive Y direction (north).
     */
    POS_Y(Axis.Y, +1),

    /**
     * The negative X direction (west).
     */
    NEG_X(Axis.X, -1),

    /**
     * The negative Y direction (south).
     */
    NEG_Y(Axis.Y, -1);

    /**
     * An axis along which a direction is aligned.
     */
    public enum Axis {
        X,
        Y
    }

    private final @NotNull Axis axis;
    private final int sign;

    FacingDirection(@NotNull Axis axis, int sign) {
        this.axis = axis;
        this.sign = sign;
    }

    public @NotNull Axis axis() {
        return this.axis;
    }

    public int sign() {
        return this.sign;
    }
}
