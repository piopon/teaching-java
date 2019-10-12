package pl.smtc.basics;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class BasicsExamplesTest extends BaseTestInOut {
    private BasicsExamples basicsExamples;

    @Override
    protected void setUp() {
        basicsExamples = new BasicsExamples();
    }

    @Test
    void executeShouldInvokeBasicsExamples() {
        simulateUserInput("0");
        basicsExamples.execute();
        String output = getOutput();
        assertTrue(output.contains("BASICS EXAMPLES"));
        assertTrue(output.contains("1) Hello world"));
        assertTrue(output.contains("2) Primitive types"));
    }

    @Test
    void getNameShouldReturnBasicsExamplesString() {
        assertEquals("Basics examples",  basicsExamples.getName());
    }
}