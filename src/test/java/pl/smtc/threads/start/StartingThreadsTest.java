package pl.smtc.threads.start;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class StartingThreadsTest extends BaseTestInOut {
    private StartingThreads startingThreads;

    @Override
    protected void setUp() {
        startingThreads = new StartingThreads();
    }

    @Test
    void executeShouldShowMenuWithStartThreadsTitle() {
        simulateUserInput("0");
        startingThreads.execute();
        String output = getOutput();
        assertTrue(output.contains("START THREADS"));
        assertTrue(output.contains("1) Extend Thread class"));
        assertTrue(output.contains("2) Implement Runnable interface"));
        assertTrue(output.contains("3) Anonymous class usage"));
        assertTrue(output.contains("4) Lambda expression usage"));
        assertTrue(output.contains("5) ExecutorService class usage"));
    }

    @Test
    void getNameShouldReturnStartThreads() {
        assertEquals("Start threads", startingThreads.getName());
    }
}