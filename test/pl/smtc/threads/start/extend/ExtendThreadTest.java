package pl.smtc.threads.start.extend;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class ExtendThreadTest extends BaseTestInOut {
    private ExtendThread extendThread;

    @Override
    protected void setUp() {
        extendThread = new ExtendThread(3, false);
    }

    @Test
    void executeShouldRunExtendThreadExample() {
        simulateUserInput(System.lineSeparator() + " " + System.lineSeparator());
        extendThread.execute();
        String output = getOutput();
        assertTrue(output.contains("> second thread is running!"));
        assertTrue(output.contains("> second thread has stopped!"));
    }

    @Test
    void getNameShouldReturnExtendThreadClass() {
        assertEquals("Extend Thread class", extendThread.getName());
    }
}