# Adventurer Journey - Back End
Please complete the story below and create a program to solve the problem. Commit any work back to the remote no later than 48 hours before the next interview.

*Please use whatever languages, references and tooling you would like to complete the story.*

## Story Instructions
You are an adventurer standing in the center of a map facing North, and you’re trying to weave through the terrain to your final destination. You have the directions to your destination indicating the number of steps and the direction to travel.

Adventurer Path & Instructions - [./Adventurer Path.md](./Adventurer%20Path.md)

Given the Path Instructions above, programmatically parse the instructions and determine what is the Euclidean (straight line) distance from your starting point to the destination in steps?

**Tech Notes:**
- Use whatever languages, references and tooling you would like.
- Provide any needed instructions to run program.
- Do not round to the nearest step.
- After program executes the answer should be returned.

# Running the Program
This is a Java project using the Gradle build system. This repository
includes the Gradle wrapper, so you should be able to run `./gradlew <command>`
directly from the command line in the project directory if gradle is not
installed globally on your machine.

You will need **Java 17** in order to build and run this project, as it uses
modern Java features like `switch` expressions and record classes. You can check
your installed Java version by running `java -version`. If you don't already have Java 17 installed,
I recommend [Eclipse Adoptium's "temurin" release](https://github.com/adoptium/temurin17-binaries/releases/).

Run `./gradlew build` to build the project, or `./gradlew test` to run the
project's unit tests. Look in `./build/libs` to find the compiled binary.

Run the jar using `java -jar ./build/libs/Adventurer-1.0-SNAPSHOT 15F6B6B5L16R8B16F20L6F13F11R`,
or replace the argument with a path of your choice.

Alternatively, if you have JetBrains IDEA, you can import the project
and use the IDE to build, test, and run it.