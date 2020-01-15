package pl.smtc.threads.locks.stamped;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class StampedExampleTest extends BaseTestOut {
    StampedExample stampedExample;

    @Override
    protected void setUp() {
        stampedExample = new StampedExample(100,10);
    }

    @Test
    void executeShouldInvokeStampedLockExample() {
        stampedExample.execute();
        String output = getOutput();
        assertTrue(output.contains("MapWriter 1 -> run [start]"));
        assertTrue(output.contains("MapReader 1 -> run [start]"));
        assertTrue(output.contains("MapReader 2 -> run [start]"));
        assertTrue(output.contains("MapWriter 1 -> added [100, -100]."));
        assertTrue(output.contains("MapReader 1 -> got value: -100"));
        assertTrue(output.contains("MapReader 2 -> got value: -100"));
        assertTrue(output.contains("MapWriter 1 -> run [stop]"));
        assertTrue(output.contains("MapReader 1 -> run [stop]"));
        assertTrue(output.contains("MapReader 2 -> run [stop]"));
    }

    @Test
    void getNameShouldReturnStampedLockExampleString() {
        assertEquals("Stamped lock example", stampedExample.getName());
    }
}