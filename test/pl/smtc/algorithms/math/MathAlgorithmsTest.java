package pl.smtc.algorithms.math;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class MathAlgorithmsTest extends BaseTestInOut {
    private MathAlgorithms mathAlgorithms;

    @Override
    protected void setUp() {
        mathAlgorithms = new MathAlgorithms();
    }

    @Test
    void execute() {
        simulateUserInput("0");
        mathAlgorithms.execute();
        String output = getOutput();
        assertTrue(output.contains("MATH ALGORITHMS"));
        assertTrue(output.contains("1) Binomial coefficient"));
        assertTrue(output.contains("2) Eratosthenes sieve"));
    }

    @Test
    void getName() {
        assertEquals("Math algorithms", mathAlgorithms.getName());
    }
}