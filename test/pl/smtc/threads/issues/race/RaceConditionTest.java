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
        String notExpectedSequenceThread1[] = { "Thread 1 -> START", "Thread 1 -> counter: 1",
                "Thread 1 -> counter: 2", "Thread 1 -> counter: 3", "Thread 1 -> counter: 4",
                "Thread 1 -> counter: 5", "Thread 1 -> counter: 6", "Thread 1 -> counter: 7",
                "Thread 1 -> counter: 8","Thread 1 -> counter: 9","Thread 1 -> counter: 10",
                "Thread 1 -> STOP"};
        assertFalse(outputContainsInOrder(output, notExpectedSequenceThread1));
        String notExpectedSequenceThread2[] = { "Thread 2 -> START", "Thread 2 -> counter: 1",
                "Thread 2 -> counter: 2", "Thread 2 -> counter: 3", "Thread 2 -> counter: 4",
                "Thread 2 -> counter: 5", "Thread 2 -> counter: 6", "Thread 2 -> counter: 7",
                "Thread 2 -> counter: 8", "Thread 2 -> counter: 9", "Thread 2 -> counter: 10",
                "Thread 2 -> STOP"};
        assertFalse(outputContainsInOrder(output, notExpectedSequenceThread2));
    }

    @Test
    void getNameShouldReturnRaceCondition() {
        assertEquals("Race condition", raceCondition.getName());
    }

    private boolean outputContainsInOrder(String current, String... expected) {
        String orderedOutput = Arrays.stream(expected).collect(Collectors.joining(System.lineSeparator()));
        return current.contains(orderedOutput);
    }
}