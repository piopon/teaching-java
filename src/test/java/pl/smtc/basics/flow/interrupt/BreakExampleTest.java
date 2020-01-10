package pl.smtc.basics.flow.interrupt;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class BreakExampleTest extends BaseTestInOut {
    private BreakExample breakExample;

    @Override
    protected void setUp() {
        breakExample = new BreakExample();
    }

    @Test
    void executeShouldInvokeBreakExample() {
        simulateCommaInput("7");
        breakExample.execute();
        String output = getOutput();
        assertTrue(output.contains("Current loop counter: 1"));
        assertTrue(output.contains("Current loop counter: 2"));
        assertTrue(output.contains("Current loop counter: 3"));
        assertFalse(output.contains("Current loop counter: 4"));
        assertFalse(output.contains("Current loop counter: 5"));
        assertFalse(output.contains("Current loop counter: 6"));
        assertFalse(output.contains("Current loop counter: 7"));
        assertTrue(output.contains("Breaking out from loop..."));
    }

    @Test
    void getNameShouldReturnBreakFromLoopString() {
        assertEquals("Break from loop", breakExample.getName());
    }
}