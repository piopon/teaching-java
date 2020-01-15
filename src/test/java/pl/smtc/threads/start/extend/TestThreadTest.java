package pl.smtc.threads.start.extend;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class TestThreadTest extends BaseTestOut {
    TestThread testThread;

    @Override
    protected void setUp() {
        testThread = new TestThread(1,4,false);
    }

    @Test
    void runShouldInvokeTestThreadWithCountdown() {
        testThread.run();
        String output = getOutput();
        assertTrue(output.contains("TestThread 1 -> run [start]"));
        assertTrue(output.contains("TestThread 1 -> run [stop]"));
    }
}