package pl.smtc.patterns.behavioral.state;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class StatePatternTest extends BaseTestInOut {
    private StatePattern statePattern;

    @Override
    protected void setUp() {
        statePattern = new StatePattern(50);
    }

    @Test
    void executeShouldInvokeStatePatternExample() {
        simulateCommaInput("print, cancel, quit");
        statePattern.execute();
        String output = getOutput();
        assertTrue(output.contains("Action [CANCEL, PRINT, QUIT]:"));
        assertTrue(output.contains("Printer is ready."));
        assertTrue(output.contains("Checking ink cassettes:"));
        assertTrue(output.contains("- black: 100%"));
        assertTrue(output.contains("- color: 50%"));
        assertTrue(output.contains("Print starting..."));
        assertTrue(output.contains("Print in progress: document1.txt"));
        assertTrue(output.contains("Added to print queue: document1.txt"));
        assertTrue(output.contains("[PRINT START] document1.txt"));
    }

    @Test
    void getNameShouldReturnStatePatternString() {
        assertEquals("State pattern", statePattern.getName());
    }
}