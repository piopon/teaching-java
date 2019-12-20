package pl.smtc.basics.flow.loops;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class WhileExampleTest extends BaseTestInOut {
    private WhileExample whileExample;

    @Override
    protected void setUp() {
        whileExample = new WhileExample();
    }

    @Test
    void executeShouldInvokeWhileExample() {
        simulateCommaInput("5");
        whileExample.execute();
        String output = getOutput();
        assertTrue(output.contains("Current loop counter: 1"));
        assertTrue(output.contains("Current loop counter: 2"));
        assertTrue(output.contains("Current loop counter: 3"));
        assertTrue(output.contains("Current loop counter: 4"));
        assertTrue(output.contains("Current loop counter: 5"));
    }

    @Test
    void getNameShouldReturnWhileLoopString() {
        assertEquals("While loop", whileExample.getName());
    }
}