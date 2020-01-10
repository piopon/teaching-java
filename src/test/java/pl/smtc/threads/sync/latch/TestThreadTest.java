package pl.smtc.threads.sync.latch;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import java.util.concurrent.CountDownLatch;

import static org.junit.jupiter.api.Assertions.*;

class TestThreadTest extends BaseTestOut {
    TestThread testThread;

    @Override
    protected void setUp() {
        CountDownLatch countdownLatch = new CountDownLatch(3);
        testThread = new TestThread(11,5, countdownLatch);
    }

    @Test
    void runShouldInvokeTestThread() {
        testThread.run();
        String output = getOutput();
        assertTrue(output.contains("TestThread 11 -> run [start]"));
        assertTrue(output.contains("TestThread 11 -> run [stop (time: "));
    }
}