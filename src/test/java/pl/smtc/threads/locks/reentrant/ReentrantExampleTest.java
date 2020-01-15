package pl.smtc.threads.locks.reentrant;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class ReentrantExampleTest extends BaseTestInOut {
    ReentrantExample reentrantExample;

    @Override
    protected void setUp() {
        reentrantExample = new ReentrantExample();
    }

    @Test
    void executeShouldInvokeReentrantLockExample() {
        simulateUserInput("3" + System.lineSeparator() + System.lineSeparator());
        reentrantExample.execute();
        String output = getOutput();
        assertTrue(output.contains("> final value: 6 (expected: 6)"));
    }

    @Test
    void getNameShouldReturnReentrantLockExampleString() {
        assertEquals("Reentrant lock example", reentrantExample.getName());
    }
}