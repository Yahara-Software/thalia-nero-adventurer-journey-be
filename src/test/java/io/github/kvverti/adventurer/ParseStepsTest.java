package io.github.kvverti.adventurer;

import io.github.kvverti.adventurer.direction.TurnAction;
import org.junit.Assert;
import org.junit.Test;

public class ParseStepsTest {
    @Test
    public void parse() throws StepParseException {
        var input = "1F2R3B4L";
        var steps = Main.parseSteps(input);
        Assert.assertEquals("Size", 4, steps.size());
        Assert.assertEquals("Step 1", new Step(TurnAction.NOT_AT_ALL, 1), steps.get(0));
        Assert.assertEquals("Step 2", new Step(TurnAction.RIGHT, 2), steps.get(1));
        Assert.assertEquals("Step 3", new Step(TurnAction.AROUND, 3), steps.get(2));
        Assert.assertEquals("Step 4", new Step(TurnAction.LEFT, 4), steps.get(3));
    }

    @Test(expected = StepParseException.class)
    public void errorAtEnd() throws StepParseException {
        var input = "1F23h";
        Main.parseSteps(input);
    }

    @Test(expected = StepParseException.class)
    public void errorInMiddle() throws StepParseException {
        var input = "1F22G3R";
        Main.parseSteps(input);
    }

    @Test(expected = StepParseException.class)
    public void errorAtBeginning() throws StepParseException {
        var input = "df2R";
        Main.parseSteps(input);
    }
}
