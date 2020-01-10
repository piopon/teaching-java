package pl.smtc.threads.issues.deadlock;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class ThreadsDeadlockTest extends BaseTestInOut {
    ThreadsDeadlock deadlock;

    @Override
    protected void setUp() {
        deadlock = new ThreadsDeadlock(20,20,100);
    }

    @Test
    void executeShouldReturnDeadlockExample() {
        simulateUserInput(System.lineSeparator());
        deadlock.execute();
        String output = getOutput();
        assertTrue(output.contains(" -> deadlock!"));
    }

    @Test
    void getNameShouldReturnThreadsDeadlock() {
        assertEquals("Threads deadlock", deadlock.getName());
    }
}