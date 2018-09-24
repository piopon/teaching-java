package pl.smtc.threads.start.extend;

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
        testThread = new TestThread(1,4,false);
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
        assertTrue(output.contains("TestThread 1 -> run [start]"));
        assertTrue(output.contains("TestThread 1 -> run [stop]"));
    }
}