package io.github.kvverti.adventurer;

import io.github.kvverti.adventurer.direction.TurnAction;
import org.junit.Assert;
import org.junit.Test;

public class PathTracerTest {
    @Test
    public void movesNorthInitially() {
        var tracer = new PathTracer();
        tracer.move(10);
        Assert.assertEquals(10, tracer.getPosY());
    }

    @Test
    public void movesAfterTurn() {
        var tracer = new PathTracer();
        tracer.turn(TurnAction.LEFT);
        tracer.move(10);
        Assert.assertEquals(-10, tracer.getPosX());
    }

    @Test
    public void movesTwoAxes() {
        var tracer = new PathTracer();
        tracer.turn(TurnAction.RIGHT);
        tracer.move(10);
        tracer.turn(TurnAction.RIGHT);
        tracer.move(10);
        Assert.assertEquals(10, tracer.getPosX());
        Assert.assertEquals(-10, tracer.getPosY());
    }

    @Test
    public void movesTwice() {
        var tracer = new PathTracer();
        tracer.move(10);
        tracer.turn(TurnAction.AROUND);
        tracer.move(7);
        Assert.assertEquals(3, tracer.getPosY());
    }
}
