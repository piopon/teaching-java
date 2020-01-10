package pl.smtc.threads.stop;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class StoppingThreadsTest extends BaseTestInOut {
    private StoppingThreads stoppingThreads;

    @Override
    protected void setUp() {
        stoppingThreads = new StoppingThreads();
    }

    @Test
    void executeShouldShowStoppingThreadsMenu() {
        simulateUserInput("0");
        stoppingThreads.execute();
        String output = getOutput();
        assertTrue(output.contains("STOPPING THREADS"));
        assertTrue(output.contains("1) Variable thread stop"));
        assertTrue(output.contains("2) Interrupt thread"));
    }

    @Test
    void getNameShouldReturnStoppingThreads() {
        assertEquals("Stopping threads", stoppingThreads.getName());
    }
}