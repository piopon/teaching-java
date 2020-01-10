package pl.smtc.threads.sync.block;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class CountdownTest extends BaseTestOut {
    Countdown countdown;

    @Override
    protected void setUp() {
        countdown = new Countdown(5);
    }

    @Test
    void countdownShouldPrintValuesFromInitToZero() {
        countdown.countdown("Test title");
        String output = getOutput();
        assertTrue(output.contains("Test title -> START"));
        assertTrue(output.contains("Test title -> countdown: 5"));
        assertTrue(output.contains("Test title -> countdown: 4"));
        assertTrue(output.contains("Test title -> countdown: 3"));
        assertTrue(output.contains("Test title -> countdown: 2"));
        assertTrue(output.contains("Test title -> countdown: 1"));
        assertTrue(output.contains("Test title -> countdown: 0"));
        assertTrue(output.contains("Test title -> STOP"));
    }


}