package pl.smtc.threads.locks.simple;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

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
        assertTrue(output.contains("Thread 1 start value: 3"));
        assertTrue(output.contains("+--> Countdown: 2  1  0"));
        assertTrue(output.contains("Thread 2 start value: 0"));
        assertTrue(output.contains("+--> Countdown: -1  -2  -3"));
    }

    @Test
    void getNameShouldReturnSimpleLockImplementationString() {
        assertEquals("Simple lock implementation", simpleLock.getName());
    }
}