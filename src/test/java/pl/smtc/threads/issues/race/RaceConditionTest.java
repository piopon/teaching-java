package pl.smtc.threads.issues.race;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class RaceConditionTest extends BaseTestInOut {
    RaceCondition raceCondition;

    @Override
    protected void setUp() {
        raceCondition = new RaceCondition();
    }

    @Test
    void executeShouldInvokeRaceConditionExample() {
        simulateUserInput("10");
        raceCondition.execute();
        String output = getOutput();
        assertTrue(output.contains("Thread 1 -> START"));
        assertTrue(output.contains("Thread 2 -> START"));
        assertTrue(outputContainsOnlyOneOf(output, "Thread 1 -> counter: 10", "Thread 2 -> counter: 1"));
        assertTrue(outputContainsOnlyOneOf(output, "Thread 1 -> counter: 1", "Thread 2 -> counter: 10"));
        assertTrue(output.contains("Thread 1 -> STOP"));
        assertTrue(output.contains("Thread 2 -> STOP"));
    }

    @Test
    void getNameShouldReturnRaceCondition() {
        assertEquals("Race condition", raceCondition.getName());
    }

    private boolean outputContainsOnlyOneOf(String current, String... expected) {
        return Arrays.stream(expected).anyMatch(current::contains);
    }
}