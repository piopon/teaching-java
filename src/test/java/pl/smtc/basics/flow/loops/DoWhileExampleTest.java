package pl.smtc.basics.flow.loops;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class DoWhileExampleTest extends BaseTestInOut {
    private DoWhileExample doWhileExample;

    @Override
    protected void setUp() {
        doWhileExample = new DoWhileExample();
    }

    @Test
    void executeShouldInvokeDoWhileExample() {
        simulateCommaInput("5");
        doWhileExample.execute();
        String output = getOutput();
        assertTrue(output.contains("Current loop counter: 1"));
        assertTrue(output.contains("Current loop counter: 2"));
        assertTrue(output.contains("Current loop counter: 3"));
        assertTrue(output.contains("Current loop counter: 4"));
        assertTrue(output.contains("Current loop counter: 5"));

    }

    @Test
    void getNameShouldReturnDoWhileLoopString() {
        assertEquals("Do-While loop", doWhileExample.getName());
    }
}