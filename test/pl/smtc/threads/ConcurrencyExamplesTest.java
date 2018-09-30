package pl.smtc.threads;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ConcurrencyExamplesTest {
    private ConcurrencyExamples concurrencyExamples;
    private static final ByteArrayOutputStream OUTPUT_STREAM = new ByteArrayOutputStream();

    @BeforeEach
    void setup() {
        concurrencyExamples = new ConcurrencyExamples();
        System.setOut(new PrintStream(OUTPUT_STREAM));
    }

    @AfterEach
    void teardown() {
        System.setOut(System.out);
        OUTPUT_STREAM.reset();
    }

    @Test
    void execute() {
        simulateUserInput("0");
        concurrencyExamples.execute();
        String output = OUTPUT_STREAM.toString();
        assertTrue(output.contains("CONCURRENCY EXAMPLES"));
        assertTrue(output.contains("1) Start threads"));
    }

    @Test
    void getName() {
        assertEquals("Concurrency examples", concurrencyExamples.getName());
    }

    private void simulateUserInput(String simInput) {
        System.setIn(new ByteArrayInputStream(simInput.getBytes()));
    }
}