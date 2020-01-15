package pl.smtc.threads.locks.simple;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SimpleLockTest extends BaseTestOut {
    SimpleLock simpleLock;

    @Override
    protected void setUp() {
        simpleLock = new SimpleLock(3, 3, 10);
    }

    @Test
    void executeShouldInvokeSimpleLockImplementation() {
        simpleLock.execute();
        String output = getOutput();
        System.out.println("Test output: " + output);
        assertTrue(outputContainsOneOf(output,
                "Thread 1 start value: 3", "Thread 2 start value: 3"));
        assertTrue(output.contains("+--> Countdown: 2  1  0"));
        assertTrue(outputContainsOneOf(output,
                "Thread 1 start value: 0", "Thread 2 start value: 0"));
        assertTrue(output.contains("+--> Countdown: -1  -2  -3"));
    }

    @Test
    void getNameShouldReturnSimpleLockImplementationString() {
        assertEquals("Simple lock implementation", simpleLock.getName());
    }

    private boolean outputContainsOneOf(String output, String ... options) {
        return Arrays.stream(options).filter(output::contains).count() == 1;
    }
}