package pl.smtc.basics.primitives.examples;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class PrimitivesExamplesTest extends BaseTestInOut {
    private PrimitivesExamples primitivesExamples;

    @Override
    protected void setUp() {
        primitivesExamples = new PrimitivesExamples();
    }

    @Test
    void executeShouldInvokePrimitivesExamplesExample() {
        simulateUserInput("0");
        primitivesExamples.execute();
        String output = getOutput();
        assertTrue(output.contains("EXAMPLES"));
        assertTrue(output.contains("1) Weight converter"));
        assertTrue(output.contains("2) Kilobytes converter"));
        assertTrue(output.contains("3) Default values"));
    }

    @Test
    void getNameShouldReturnExamplesString() {
        assertEquals("Examples", primitivesExamples.getName());
    }
}