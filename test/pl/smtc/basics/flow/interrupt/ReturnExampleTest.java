package pl.smtc.basics.flow.interrupt;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class ReturnExampleTest extends BaseTestInOut {
    private ReturnExample returnExample;

    @Override
    protected void setUp() {
        returnExample = new ReturnExample();
    }

    @Test
    void executeShouldInvokeReturnExample() {
        simulateCommaInput("10");
        returnExample.execute();
        String output = getOutput();
        assertTrue(output.contains("Current loop counter: 1"));
        assertTrue(output.contains("Current loop counter: 2"));
        assertTrue(output.contains("Current loop counter: 3"));
        assertTrue(output.contains("Current loop counter: 4"));
        assertTrue(output.contains("Current loop counter: 5"));
        assertFalse(output.contains("Current loop counter: 6"));
        assertFalse(output.contains("Current loop counter: 7"));
        assertFalse(output.contains("Current loop counter: 8"));
        assertFalse(output.contains("Current loop counter: 9"));
        assertFalse(output.contains("Current loop counter: 10"));
        assertTrue(output.contains("Returning from loop (and method)..."));
    }

    @Test
    void getNameShouldReturnReturnFromLoopString() {
        assertEquals("Return from loop", returnExample.getName());
    }
}