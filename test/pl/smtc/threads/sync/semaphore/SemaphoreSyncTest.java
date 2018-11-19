package pl.smtc.threads.sync.semaphore;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class SemaphoreSyncTest extends BaseTestInOut {
    SemaphoreSync semaphoreSync;

    @Override
    protected void setUp() {
        semaphoreSync = new SemaphoreSync(50);
    }

    @Test
    void executeShouldInvokeSemaphoreSyncExample() {
        simulateUserInput("4" + System.lineSeparator());
        semaphoreSync.execute();
        String output = getOutput();
        assertTrue(output.contains("FTP access OK [current connections: 1]"));
        assertTrue(output.contains("FTP access OK [current connections: 2]"));
        assertTrue(output.contains("FTP access OK [current connections: 3]"));
        assertFalse(output.contains("FTP access OK [current connections: 4]"));
    }

    @Test
    void getNameShouldReturnSynchronizeWithSemaphore() {
        assertEquals("Synchronize with semaphore", semaphoreSync.getName());
    }
}