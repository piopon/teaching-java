package pl.smtc.algorithms;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class AlgorithmsExamplesTest extends BaseTestInOut {
    private AlgorithmsExamples algorithmsExamples;

    @Override
    protected void setUp() {
        algorithmsExamples = new AlgorithmsExamples();
    }

    @Test
    void executeShouldInvokeAlgorithmExamples() {
        simulateUserInput("0");
        algorithmsExamples.execute();
        String output = getOutput();
        assertTrue(output.contains("ALGORITHM EXAMPLES"));
        assertTrue(output.contains("1) Sort algorithms"));
        assertTrue(output.contains("2) Search algorithms"));
        assertTrue(output.contains("3) Math algorithms"));
    }

    @Test
    void getNameShouldReturnAlgorithmExamplesString() {
        assertEquals("Algorithm examples", algorithmsExamples.getName());
    }
}