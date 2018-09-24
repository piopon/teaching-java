package pl.smtc.threads.start.executors;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class UseExecutorsTest {
    private UseExecutors useExecutors;
    private static final ByteArrayOutputStream OUTPUT_STREAM = new ByteArrayOutputStream();

    @BeforeEach
    void setup() {
        useExecutors = new UseExecutors(10);
        System.setOut(new PrintStream(OUTPUT_STREAM));
    }

    @AfterEach
    void teardown() {
        System.setIn(System.in);
        System.setOut(System.out);
        OUTPUT_STREAM.reset();
    }

    @Test
    void execute() {
        simulateUserInput("1" + System.lineSeparator() + "1" + System.lineSeparator());
        useExecutors.execute();
        String output = OUTPUT_STREAM.toString();
        assertTrue(output.contains("ExecutorService -> 1 tasks submitted!"));
        assertTrue(output.contains("ExecutorService -> running with 1 threads!"));
        assertTrue(output.contains("ExecutorService -> all tasks completed!"));
    }

    @Test
    void getName() {
        assertEquals("ExecutorService class usage", useExecutors.getName());
    }

    private void simulateUserInput(String simInput) {
        System.setIn(new ByteArrayInputStream(simInput.getBytes()));
    }
}