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
        assertTrue(output.contains("CommObjectReceive-> got LOCK 2"));
        assertTrue(output.contains("CommObjectSend-> got LOCK 1"));
        assertTrue(output.contains("CommObjectReceive -> wait LOCK 1"));
        assertTrue(output.contains("CommObjectSend -> wait LOCK 2"));
    }

    @Test
    void getNameShouldReturnThreadsDeadlock() {
        assertEquals("Threads deadlock", deadlock.getName());
    }
}