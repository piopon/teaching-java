package pl.smtc.threads.issues.slip;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class SlipConditionsTest extends BaseTestOut {
    SlipConditions slipConditions;

    @Override
    protected void setUp() {
        slipConditions = new SlipConditions(10);
    }

    @Test
    void executeShouldInvokeSlippedConditionsExample() {
        slipConditions.execute();
        String output = getOutput();
        String notExpectedSequence[] = {
                "Thread 1 -> waiting for lock.", "Thread 1 -> lock free.",
                "Thread 1 -> acquired lock.", "Thread 1 -> working...",
                "Thread 1 -> released lock.", "Thread 2 -> waiting for lock.",
                "Thread 2 -> lock free.", "Thread 2 -> acquired lock.",
                "Thread 2 -> working...", "Thread 2 -> released lock." };
        assertFalse(outputContainsInOrder(output, notExpectedSequence));
    }

    @Test
    void getNameShouldReturnSlippedConditions() {
        assertEquals("Slipped conditions", slipConditions.getName());
    }

    private boolean outputContainsInOrder(String current, String... expected) {
        String orderedOutput = Arrays.stream(expected).collect(Collectors.joining(System.lineSeparator()));
        return current.contains(orderedOutput);
    }
}