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
        assertFalse(output.contains("FTP access OK [current connections: 5]"));
        assertTrue(output.contains("all 4 receivers used resource"));
    }

    @Test
    void getNameShouldReturnSynchronizeWithSemaphore() {
        assertEquals("Synchronize with semaphore", semaphoreSync.getName());
    }
}