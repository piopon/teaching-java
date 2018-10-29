package pl.smtc.threads.stop.interrupt;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class InterruptStopTest extends BaseTestInOut {
    private InterruptStop interruptStop;

    @Override
    public void setUp() {
        interruptStop = new InterruptStop();
    }

    @Test
    void executeRunsInterruptStopExample() {
        simulateUserInput(System.lineSeparator() + " " + System.lineSeparator());
        interruptStop.execute();
        String output = getOutput();
        assertTrue(output.contains("> press Enter to interrupt alphabet thread."));
        assertTrue(output.contains("> alphabet thread ended."));
    }

    @Test
    void getNameShouldReturnInterruptThread() {
        assertEquals("Interrupt thread", interruptStop.getName());

    }
}