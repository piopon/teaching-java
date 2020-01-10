package pl.smtc.threads.start.implement;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class ImplementRunnableTest extends BaseTestInOut {
    private ImplementRunnable implementRunnable;

    @Override
    protected void setUp() {
        implementRunnable = new ImplementRunnable(3, false);
    }

    @Test
    void executeShouldRunImplementRunnableExample() {
        simulateUserInput(System.lineSeparator() + " " + System.lineSeparator());
        implementRunnable.execute();
        String output = getOutput();
        assertTrue(output.contains("> second thread is running!"));
        assertTrue(output.contains("> second thread has stopped!"));
    }

    @Test
    void getNameShouldReturnImplementRunnableInterface() {
        assertEquals("Implement Runnable interface", implementRunnable.getName());
    }
}