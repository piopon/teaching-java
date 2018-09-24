package pl.smtc.threads.start.implement;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class TestThreadTest {
    TestThread testThread;
    private static final ByteArrayOutputStream OUTPUT_STREAM = new ByteArrayOutputStream();

    @BeforeEach
    void setup() {
        testThread = new TestThread(3,15,true);
        System.setOut(new PrintStream(OUTPUT_STREAM));
    }

    @AfterEach
    void teardown() {
        System.setOut(System.out);
        OUTPUT_STREAM.reset();
    }

    @Test
    void runShouldInvokeTestThreadWithCountdown() {
        testThread.run();
        String output = OUTPUT_STREAM.toString();
        assertTrue(output.contains("TestThread 3 -> run [start]"));
        assertTrue(output.contains("TestThread 3 -> counter: 0"));
        assertTrue(output.contains("TestThread 3 -> counter: 5"));
        assertTrue(output.contains("TestThread 3 -> counter: 10"));
        assertTrue(output.contains("TestThread 3 -> run [stop]"));
    }
}