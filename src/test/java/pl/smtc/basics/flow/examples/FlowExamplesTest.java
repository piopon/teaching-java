package pl.smtc.basics.flow.examples;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class FlowExamplesTest extends BaseTestInOut {
    private FlowExamples flowExamples;

    @Override
    protected void setUp() {
        flowExamples = new FlowExamples();
    }

    @Test
    void executeShouldInvokeExamplesMenu() {
        simulateUserInput("0");
        flowExamples.execute();
        String output = getOutput();
        assertTrue(output.contains("EXAMPLES"));
        assertTrue(output.contains("1) Sum odd numbers"));
        assertTrue(output.contains("2) Palindrome number"));
        assertTrue(output.contains("3) Bound digits sum"));
        assertTrue(output.contains("4) All number factors"));
        assertTrue(output.contains("5) Perfect number"));
        assertTrue(output.contains("6) Diagonal star"));
        assertTrue(output.contains("7) Days in month"));
    }

    @Test
    void getNameShouldReturnExamplesString() {
        assertEquals("Examples", flowExamples.getName());
    }
}