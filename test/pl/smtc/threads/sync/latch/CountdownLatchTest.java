package pl.smtc.threads.sync.latch;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class CountdownLatchTest extends BaseTestInOut {
    CountdownLatch countdownLatch;

    @Override
    protected void setUp() {
        countdownLatch = new CountdownLatch(10,100);
    }

    @Test
    void executeShouldInvokeCountdownLatchExample() {
        simulateUserInput("3" + System.lineSeparator());
        countdownLatch.execute();
        String output = getOutput();
        assertTrue(output.contains("> countdown with latch completed."));
    }

    @Test
    void getNameShouldReturnCountdownLatch() {
        assertEquals("Countdown latch", countdownLatch.getName());
    }
}