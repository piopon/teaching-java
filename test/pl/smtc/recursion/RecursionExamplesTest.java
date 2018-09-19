package pl.smtc.recursion;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class RecursionExamplesTest {
    private RecursionExamples recursionExamples;
    private static final ByteArrayOutputStream OUTPUT_STREAM = new ByteArrayOutputStream();

    @BeforeEach
    void setup() {
        recursionExamples = new RecursionExamples();
        System.setOut(new PrintStream(OUTPUT_STREAM));
    }

    @AfterEach
    void teardown() {
        System.setIn(System.in);
        System.setOut(System.out);
        OUTPUT_STREAM.reset();
    }

    @Test
    void executeShouldShowRecursionMenu() {
        simulateUserInput("0");
        recursionExamples.execute();
        String output = OUTPUT_STREAM.toString();
        assertTrue(output.contains("1) Factorial"));
        assertTrue(output.contains("2) Fibonacci"));
        assertTrue(output.contains("3) Decimal to Binary"));
        assertTrue(output.contains("4) Greatest common divisor"));
        assertTrue(output.contains("5) Raise number to power"));
        assertTrue(output.contains("6) Linked list"));
        assertTrue(output.contains("7) Directory explorer"));
        assertTrue(output.contains("8) Quick sort"));
    }

    @Test
    void getNameShouldReturnRecursionExamples() {
        assertEquals("Recursion examples", recursionExamples.getName());
    }

    private void simulateUserInput(String simInput) {
        System.setIn(new ByteArrayInputStream(simInput.getBytes()));
    }
}