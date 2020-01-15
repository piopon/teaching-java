package pl.smtc.basics.flow.loops;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class ForExampleTest extends BaseTestInOut {
    private ForExample forExample;

    @Override
    protected void setUp() {
        forExample = new ForExample();
    }

    @Test
    void executeShouldInvokeForExample() {
        simulateCommaInput("5");
        forExample.execute();
        String output = getOutput();
        assertTrue(output.contains("Current loop counter: 1"));
        assertTrue(output.contains("Current loop counter: 2"));
        assertTrue(output.contains("Current loop counter: 3"));
        assertTrue(output.contains("Current loop counter: 4"));
        assertTrue(output.contains("Current loop counter: 5"));
    }

    @Test
    void getNameShouldReturnForLoopString() {
        assertEquals("For loop", forExample.getName());
    }
}