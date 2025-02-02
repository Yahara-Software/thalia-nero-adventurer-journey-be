package io.github.kvverti.adventurer;

import io.github.kvverti.adventurer.direction.FacingDirection;
import io.github.kvverti.adventurer.direction.TurnAction;
import org.jetbrains.annotations.NotNull;

public final class PathTracer {
    /**
     * The current facing direction of this tracer.
     */
    private @NotNull FacingDirection facing;

    /**
     * The current X position of this tracer.
     */
    private int posX;

    /**
     * The current Y position of this tracer.
     */
    private int posY;

    /**
     * Constructs a default tracer facing north (+Y) and positioned at the origin.
     */
    public PathTracer() {
        this.facing = FacingDirection.POS_Y;
        this.posX = 0;
        this.posY = 0;
    }

    /**
     * The current X position of this tracer.
     */
    public int getPosX() {
        return this.posX;
    }

    /**
     * The current Y position of this tracer.
     */
    public int getPosY() {
        return this.posY;
    }

    /**
     * Turns this tracer with the given action.
     */
    public void turn(@NotNull TurnAction action) {
        this.facing = action.turn(this.facing);
    }

    /**
     * Moves this tracer forward the given number of units.
     */
    public void move(int units) {
        switch(this.facing.axis()) {
            case X -> this.posX += units * this.facing.sign();
            case Y -> this.posY += units * this.facing.sign();
        }
    }
}
