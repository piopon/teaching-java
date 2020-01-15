package pl.smtc.threads.comm.basic;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class CountThreadTest extends BaseTestOut {
    private CountThread countThread;
    private int testThreadId = 37;
    private int maxCount = 5;

    @Override
    protected void setUp() {
        countThread = new CountThread(testThreadId, maxCount, true);
    }

    @Test
    void runMethodStartsCounter() {
        countThread.run();
        String output = getOutput();
        assertTrue(output.contains("CountThread " + testThreadId + " -> run [start]"));
        assertTrue(output.contains("CountThread " + testThreadId + " -> count: " + maxCount));
        assertTrue(output.contains("CountThread " + testThreadId + " -> run [stop]"));
    }

    @Test
    void shutdownMethodSwitchRunVariableToFalse() {
        assertTrue(countThread.run);
        countThread.shutdown();
        assertFalse(countThread.run);
    }

    @Test
    void counterOnMethodSwitchShowCounterVariableToTrue() {
        countThread.counterOn();
        assertTrue(countThread.showCounter);
    }

    @Test
    void counterOffMethodSwitchShowCounterVariableToFalse() {
        countThread.counterOff();
        assertFalse(countThread.showCounter);
    }
}