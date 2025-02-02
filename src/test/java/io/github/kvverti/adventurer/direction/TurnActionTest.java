package io.github.kvverti.adventurer.direction;

import org.junit.Assert;
import org.junit.Test;

public final class TurnActionTest {
    @Test
    public void turnNotAtAll() {
        var inputs = FacingDirection.values();
        for(var direction : inputs) {
            Assert.assertEquals(direction, TurnAction.NOT_AT_ALL.turn(direction));
        }
    }

    @Test
    public void turnLeft() {
        var action = TurnAction.LEFT;
        Assert.assertEquals(FacingDirection.POS_X, action.turn(FacingDirection.NEG_Y));
        Assert.assertEquals(FacingDirection.POS_Y, action.turn(FacingDirection.POS_X));
        Assert.assertEquals(FacingDirection.NEG_X, action.turn(FacingDirection.POS_Y));
        Assert.assertEquals(FacingDirection.NEG_Y, action.turn(FacingDirection.NEG_X));
    }

    @Test
    public void turnRight() {
        var action = TurnAction.RIGHT;
        Assert.assertEquals(FacingDirection.POS_X, action.turn(FacingDirection.POS_Y));
        Assert.assertEquals(FacingDirection.POS_Y, action.turn(FacingDirection.NEG_X));
        Assert.assertEquals(FacingDirection.NEG_X, action.turn(FacingDirection.NEG_Y));
        Assert.assertEquals(FacingDirection.NEG_Y, action.turn(FacingDirection.POS_X));
    }

    @Test
    public void turnAround() {
        var action = TurnAction.AROUND;
        Assert.assertEquals(FacingDirection.POS_X, action.turn(FacingDirection.NEG_X));
        Assert.assertEquals(FacingDirection.POS_Y, action.turn(FacingDirection.NEG_Y));
        Assert.assertEquals(FacingDirection.NEG_X, action.turn(FacingDirection.POS_X));
        Assert.assertEquals(FacingDirection.NEG_Y, action.turn(FacingDirection.POS_Y));
    }
}
