package io.github.kvverti.adventurer;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import io.github.kvverti.adventurer.direction.TurnAction;
import org.jetbrains.annotations.VisibleForTesting;

public class Main {
    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("Usage: adventurer <path>");
            return;
        }

        var pathStr = args[0];
        List<Step> steps;
        try {
            steps = parseSteps(pathStr);
        } catch(StepParseException e) {
            System.err.println(e.getMessage() + ": " + e.getCause());
            return;
        }

        var tracer = new PathTracer();
        applySteps(tracer, steps);
        var finalX = tracer.getPosX();
        var finalY = tracer.getPosY();
        var displacement = Math.sqrt(finalX * finalX + finalY * finalY);
        System.out.println("Euclidean distance: " + displacement);
    }

    private static final Pattern STEP_PATTERN = Pattern.compile("(\\d+)([FBLR])");

    @VisibleForTesting
    static List<Step> parseSteps(String input) throws StepParseException {
        var result = new ArrayList<Step>();
        var matcher = STEP_PATTERN.matcher(input);

        try {
            while(matcher.find()) {
                var distance = Integer.parseInt(matcher.group(1));
                var turnChar = matcher.group(2).charAt(0);
                var turn = TurnAction.fromIndicator(turnChar);
                result.add(new Step(turn, distance));
            }
        } catch(RuntimeException e) {
            throw new StepParseException("Exception parsing steps", e);
        }

        return result;
    }

    private static void applySteps(PathTracer tracer, List<Step> steps) {
        for(var step : steps) {
            tracer.turn(step.turn());
            tracer.move(step.distance());
        }
    }
}