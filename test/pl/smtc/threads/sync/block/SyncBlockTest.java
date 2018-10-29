package pl.smtc.threads.sync.block;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class SyncBlockTest extends BaseTestInOut {
    SyncBlock syncBlock;

    @Override
    protected void setUp() {
        syncBlock = new SyncBlock();
    }

    @Test
    void executeShouldRunSyncBlockExample() {
        simulateUserInput("3" + System.lineSeparator());
        syncBlock.execute();
        String output = getOutput();
        assertTrue(output.contains("Thread 1 -> START"));
        assertTrue(output.contains("Thread 2 -> START"));
        assertTrue(output.contains("Thread 1 -> countdown: 3"));
        assertTrue(output.contains("Thread 1 -> countdown: 2"));
        assertTrue(output.contains("Thread 1 -> countdown: 1"));
        assertTrue(output.contains("Thread 1 -> countdown: 0"));
        assertTrue(output.contains("Thread 2 -> countdown: 3"));
        assertTrue(output.contains("Thread 2 -> countdown: 2"));
        assertTrue(output.contains("Thread 2 -> countdown: 1"));
        assertTrue(output.contains("Thread 2 -> countdown: 0"));
        assertTrue(output.contains("Thread 1 -> STOP"));
        assertTrue(output.contains("Thread 2 -> STOP"));
    }

    @Test
    void getNameShouldReturnSynchronizedBlock() {
        assertEquals("Synchronized block", syncBlock.getName());
    }
}