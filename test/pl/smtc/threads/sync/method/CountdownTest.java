package pl.smtc.threads.sync.method;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class CountdownTest extends BaseTestOut {
    Countdown countdown;

    @Override
    protected void setUp() {
        countdown = new Countdown(3);
    }

    @Test
    void countdownShouldInvokeCountdownMethod() {
        countdown.countdown("Count title");
        String output = getOutput();
        assertTrue(output.contains("Count title -> START"));
        assertTrue(output.contains("Count title -> countdown: 3"));
        assertTrue(output.contains("Count title -> countdown: 2"));
        assertTrue(output.contains("Count title -> countdown: 1"));
        assertTrue(output.contains("Count title -> STOP"));
    }
}