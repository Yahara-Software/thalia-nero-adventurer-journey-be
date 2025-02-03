package io.github.kvverti.adventurer;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

import io.github.kvverti.adventurer.direction.TurnAction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.VisibleForTesting;

/**
 * Entry point.
 */
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

    /**
     * Regex for a single step; e.g., 1F, 23R. We force matching a prefix of the input.
     */
    private static final Pattern STEP_PATTERN = Pattern.compile("\\G(\\d+)([FBLR])");

    /**
     * Parses a list of steps from its string representation.
     * @param input a string representing a list of steps
     * @return a list of steps
     * @throws StepParseException if the string is malformed
     */
    @VisibleForTesting
    static List<Step> parseSteps(@Nullable String input) throws StepParseException {
        var result = new ArrayList<Step>();
        if(input == null || input.isEmpty()) {
            return result;
        }

        var matcher = STEP_PATTERN.matcher(input);
        @Nullable MatchResult lastMatch = null;

        try {
            while(matcher.find()) {
                lastMatch = matcher.toMatchResult();
                var distance = Integer.parseInt(matcher.group(1));
                var turnChar = matcher.group(2).charAt(0);
                var turn = TurnAction.fromIndicator(turnChar);
                result.add(new Step(turn, distance));
            }
        } catch(NumberFormatException e) {
            throw new StepParseException("Exception parsing steps", e);
        }

        // check that there aren't trailing characters that weren't parsed.
        // no matches means that the beginning of the input could not be parsed.
        if(lastMatch == null || lastMatch.end() != input.length()) {
            var index = lastMatch == null ? 0 : lastMatch.end();
            throw new StepParseException("Some steps could not be parsed: index " + index);
        }

        return result;
    }

    /**
     * Applies the given list of steps to the given path tracer by appropriately
     * turning and moving the tracer.
     * @param tracer the tracer to step
     * @param steps list of steps to apply
     */
    private static void applySteps(@NotNull PathTracer tracer, @NotNull List<Step> steps) {
        for(var step : steps) {
            tracer.turn(step.turn());
            tracer.move(step.distance());
        }
    }
}