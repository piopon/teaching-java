package pl.smtc.threads.sync.method;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class SyncMethodTest extends BaseTestInOut {
    SyncMethod syncMethod;

    @Override
    protected void setUp() {
        syncMethod = new SyncMethod();
    }

    @Test
    void executeShouldInvokeSyncMethodExample() {
        simulateUserInput("3" + System.lineSeparator());
        syncMethod.execute();
        String output = getOutput();
        assertTrue(output.contains("Thread 1 -> START"));
        assertTrue(output.contains("Thread 1 -> countdown: 3"));
        assertTrue(output.contains("Thread 1 -> countdown: 2"));
        assertTrue(output.contains("Thread 1 -> countdown: 1"));
        assertTrue(output.contains("Thread 1 -> STOP"));
        assertTrue(output.contains("Thread 2 -> START"));
        assertTrue(output.contains("Thread 2 -> countdown: 3"));
        assertTrue(output.contains("Thread 2 -> countdown: 2"));
        assertTrue(output.contains("Thread 2 -> countdown: 1"));
        assertTrue(output.contains("Thread 2 -> STOP"));
    }

    @Test
    void getNameShouldReturnSynchronizedMethod() {
        assertEquals("Synchronized method", syncMethod.getName());
    }
}