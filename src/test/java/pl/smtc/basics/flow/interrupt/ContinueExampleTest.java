package pl.smtc.basics.flow.interrupt;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class ContinueExampleTest extends BaseTestInOut {
    private ContinueExample continueExample;

    @Override
    protected void setUp() {
        continueExample = new ContinueExample();
    }

    @Test
    void executeShouldInvokeContinueLoopExample() {
        simulateCommaInput("5");
        continueExample.execute();
        String output = getOutput();
        assertTrue(output.contains("Current loop counter: 1"));
        assertTrue(output.contains("Current loop counter: 2"));
        assertFalse(output.contains("Current loop counter: 3"));
        assertTrue(output.contains("Current loop counter: 4"));
        assertTrue(output.contains("Current loop counter: 5"));
        assertTrue(output.contains("Continuing loop from top..."));
    }

    @Test
    void getNameShouldReturnContinueLoopFromStartString() {
        assertEquals("Continue loop from start", continueExample.getName());
    }
}