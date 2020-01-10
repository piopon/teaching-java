package pl.smtc.recursion;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class RecursionExamplesTest extends BaseTestInOut {
    private RecursionExamples recursionExamples;

    @Override
    protected void setUp() {
        recursionExamples = new RecursionExamples();
    }

    @Test
    void executeShouldShowRecursionMenu() {
        simulateUserInput("0");
        recursionExamples.execute();
        String output = getOutput();
        assertTrue(output.contains("1) Factorial"));
        assertTrue(output.contains("2) Fibonacci"));
        assertTrue(output.contains("3) Decimal to Binary"));
        assertTrue(output.contains("4) Greatest common divisor"));
        assertTrue(output.contains("5) Raise number to power"));
        assertTrue(output.contains("6) Linked list"));
        assertTrue(output.contains("7) Directory explorer"));
    }

    @Test
    void getNameShouldReturnRecursionExamples() {
        assertEquals("Recursion examples", recursionExamples.getName());
    }
}