package io.github.kvverti.adventurer;

/**
 * Thrown when a list of steps cannot be parsed.
 */
public class StepParseException extends Exception {
    public StepParseException(String message, Throwable cause) {
        super(message, cause);
    }
}
