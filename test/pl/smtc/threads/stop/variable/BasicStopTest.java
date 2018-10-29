package pl.smtc.threads.stop.variable;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class BasicStopTest extends BaseTestInOut {
    private BasicStop basicStop;

    @Override
    protected void setUp() {
        basicStop = new BasicStop();
    }

    @Test
    void executeShouldRunBasicStopExample() {
        simulateUserInput(System.lineSeparator() + " " + System.lineSeparator());
        basicStop.execute();
        String output = getOutput();
        assertTrue(output.contains("Press Enter to stop counter thread."));
        assertTrue(output.contains("Counter thread stopped."));
    }

    @Test
    void getNameShouldReturnVariableThreadStop() {
        assertEquals("Variable thread stop", basicStop.getName());
    }
}