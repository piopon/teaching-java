package pl.smtc.threads.stop.interrupt;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class AlphabetThreadTest extends BaseTestOut {
    private AlphabetThread alphabetThread;

    @Override
    protected void setUp() {
        alphabetThread = new AlphabetThread(111, 360);
    }

    @Test
    void runTriggersAlphabetCountdown() {
        alphabetThread.run();
        String output = getOutput();
        assertTrue(output.contains("AlphabetThread 111 -> run [start]"));
        assertTrue(output.contains("AlphabetThread 111 -> interrupted!"));
        assertTrue(output.contains("AlphabetThread 111 -> last char: "));
    }
}