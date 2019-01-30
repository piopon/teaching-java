package pl.smtc.algorithms.math;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

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
        assertTrue(output.contains("1) Prime numbers"));
        assertTrue(output.contains("2) Bits algorithms"));
        assertTrue(output.contains("3) Least common multiplier"));
        assertTrue(output.contains("4) Sum of all digits"));
        assertTrue(output.contains("5) Binomial coefficient"));
        assertTrue(output.contains("6) Catalan numbers"));
        assertTrue(output.contains("7) Hoax numbers"));
        assertTrue(output.contains("8) Sphenic numbers"));
        assertTrue(output.contains("9) Euler totient function"));
    }

    @Test
    void getName() {
        assertEquals("Math algorithms", mathAlgorithms.getName());
    }
}