package pl.smtc.threads.locks;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class ThreadLocksTest extends BaseTestInOut {
    ThreadLocks threadLocks;

    @Override
    protected void setUp() {
        threadLocks = new ThreadLocks();
    }

    @Test
    void executeShouldShowUserMenuWithThreadLocksExamples() {
        simulateUserInput("0");
        threadLocks.execute();
        String output = getOutput();
        assertTrue(output.contains("THREADS LOCKS"));
        assertTrue(output.contains("1) Simple lock implementation"));
        assertTrue(output.contains("2) Reentrant lock example"));
        assertTrue(output.contains("3) Fair lock example"));
        assertTrue(output.contains("4) Read write lock example"));
        assertTrue(output.contains("5) Stamped lock example"));
        assertTrue(output.contains("6) Optimistic lock example"));
    }

    @Test
    void getNameShouldReturnThreadLocksString() {
        assertEquals("Threads locks", threadLocks.getName());
    }
}