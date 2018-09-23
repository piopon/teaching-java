package pl.smtc.threads.start;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class StartingThreadsTest {
    private StartingThreads startingThreads;
    private static final ByteArrayOutputStream OUTPUT_STREAM = new ByteArrayOutputStream();

    @BeforeEach
    void setup() {
        startingThreads = new StartingThreads();
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
        startingThreads.execute();
        String output = OUTPUT_STREAM.toString();
        assertTrue(output.contains("START THREADS"));
        assertTrue(output.contains("1) Extend Thread class"));
        assertTrue(output.contains("2) Implement Runnable interface"));
        assertTrue(output.contains("3) Anonymous class usage"));
        assertTrue(output.contains("4) Lambda expression usage"));
        assertTrue(output.contains("5) ExecutorService class usage"));
    }

    @Test
    void getName() {
        assertEquals("Start threads", startingThreads.getName());
    }

    private void simulateUserInput(String simInput) {
        System.setIn(new ByteArrayInputStream(simInput.getBytes()));
    }
}