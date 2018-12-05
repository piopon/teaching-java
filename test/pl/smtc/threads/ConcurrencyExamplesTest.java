package pl.smtc.threads;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class ConcurrencyExamplesTest extends BaseTestInOut {
    private ConcurrencyExamples concurrencyExamples;

    @Override
    protected void setUp() {
        concurrencyExamples = new ConcurrencyExamples();
    }

    @Test
    void executeShouldShowUserMenuWithConcurrencyExamples() {
        simulateUserInput("0");
        concurrencyExamples.execute();
        String output = getOutput();
        assertTrue(output.contains("CONCURRENCY EXAMPLES"));
        assertTrue(output.contains("1) Start threads"));
        assertTrue(output.contains("2) Stopping threads"));
        assertTrue(output.contains("3) Synchronizing threads"));
        assertTrue(output.contains("4) Threads locks"));
        assertTrue(output.contains("5) Threads communication"));
        assertTrue(output.contains("6) Threads issues"));
    }

    @Test
    void getNameShouldReturnConcurrencyExamples() {
        assertEquals("Concurrency examples", concurrencyExamples.getName());
    }
}