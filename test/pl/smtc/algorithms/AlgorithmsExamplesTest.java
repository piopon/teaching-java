package pl.smtc.algorithms;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class AlgorithmsExamplesTest extends BaseTestInOut {
    AlgorithmsExamples algorithmsExamples;

    @Override
    protected void setUp() {
        algorithmsExamples = new AlgorithmsExamples();
    }

    @Test
    void execute() {
        simulateUserInput("0");
        algorithmsExamples.execute();
        String output = getOutput();
        assertTrue(output.contains("ALGORITHM EXAMPLES"));
        assertTrue(output.contains("1) Sort algorithms"));
        assertTrue(output.contains("2) Search algorithms"));
    }

    @Test
    void getNameShouldReturnAlgorithmExamplesString() {
        assertEquals("Algorithm examples", algorithmsExamples.getName());
    }
}