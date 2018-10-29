package pl.smtc.threads.start.executors;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class UseExecutorsTest extends BaseTestInOut {
    private UseExecutors useExecutors;

    @Override
    protected void setUp() {
        useExecutors = new UseExecutors(10);
    }

    @Test
    void executeShouldRunUseExecutorsExample() {
        simulateUserInput("1" + System.lineSeparator() + "1" + System.lineSeparator());
        useExecutors.execute();
        String output = getOutput();
        assertTrue(output.contains("ExecutorService -> 1 tasks submitted!"));
        assertTrue(output.contains("ExecutorService -> running with 1 threads!"));
        assertTrue(output.contains("ExecutorService -> all tasks completed!"));
    }

    @Test
    void getNameShouldReturnExecutorServiceClassUsage() {
        assertEquals("ExecutorService class usage", useExecutors.getName());
    }
}