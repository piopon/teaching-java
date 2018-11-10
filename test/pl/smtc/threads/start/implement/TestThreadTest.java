package pl.smtc.threads.start.implement;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class TestThreadTest extends BaseTestOut {
    TestThread testThread;

    @Override
    protected void setUp() {
        testThread = new TestThread(3,6,true);
    }

    @Test
    void runShouldInvokeTestThreadWithCountdown() {
        testThread.run();
        String output = getOutput();
        assertTrue(output.contains("TestThread 3 -> run [start]"));
        assertTrue(output.contains("TestThread 3 -> counter: 0"));
        assertTrue(output.contains("TestThread 3 -> counter: 5"));
        assertTrue(output.contains("TestThread 3 -> run [stop]"));
    }
}