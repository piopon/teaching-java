package pl.smtc.threads.issues.starvation;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ThreadsStarvationTest extends BaseTestOut {
    ThreadsStarvation threadsStarvation;

    @Override
    protected void setUp() {
        threadsStarvation = new ThreadsStarvation();
    }

    @Test
    void executeShouldInvokeThreadsStarvationExample() {
        threadsStarvation.execute();
        String output = getOutput();
        String notExpectedSequence1[] = {"Thread priority 1 -> count: 0",
                "Thread priority 1 -> count: 100", "Thread priority 1 -> count: 200",
                "Thread priority 1 -> count: 300", "Thread priority 1 -> count: 400"};
        assertFalse(outputContainsInOrder(output, notExpectedSequence1));
        String notExpectedSequence2[] = {"Thread priority 6 -> count: 0",
                "Thread priority 6 -> count: 100", "Thread priority 6 -> count: 200",
                "Thread priority 6 -> count: 300", "Thread priority 6 -> count: 400"};
        assertFalse(outputContainsInOrder(output, notExpectedSequence2));
        String notExpectedSequence3[] = {"Thread priority 10 -> count: 0",
                "Thread priority 10 -> count: 100", "Thread priority 10 -> count: 200",
                "Thread priority 10 -> count: 300", "Thread priority 10 -> count: 400"};
        assertFalse(outputContainsInOrder(output, notExpectedSequence3));
    }

    @Test
    void getNameShouldReturnThreadsStarvation() {
        assertEquals("Thread starvation", threadsStarvation.getName());
    }

    private boolean outputContainsInOrder(String current, String... expected) {
        String orderedOutput = Arrays.stream(expected).collect(Collectors.joining(System.lineSeparator()));
        return current.contains(orderedOutput);
    }
}