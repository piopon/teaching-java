package pl.smtc.threads.stop.variable;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class CountThreadTest extends BaseTestOut {
    CountThread countThread;

    @Override
    protected void setUp() {
        countThread = new CountThread(17, 200);
    }

    @Test
    void runTriggersCountThread() {
        countThread.run();
        String output = getOutput();
        assertTrue(output.contains("CountThread 17 -> run [start]"));
        assertTrue(output.contains("CountThread 17 -> interrupted!"));
        assertTrue(output.contains("CountThread 17 -> counter: "));
    }

    @Test
    void shutdownShouldChangeRunStatusFlag() {
        assertTrue(countThread.getRunStatus());
        countThread.shutdown();
        assertFalse(countThread.getRunStatus());
    }
}