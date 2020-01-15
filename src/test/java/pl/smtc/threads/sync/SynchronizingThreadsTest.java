package pl.smtc.threads.sync;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class SynchronizingThreadsTest extends BaseTestInOut {
    SynchronizingThreads synchronizingThreads;

    @Override
    protected void setUp() {
        synchronizingThreads = new SynchronizingThreads();
    }

    @Test
    void executeShouldShowMenuWithSynchronizingThreadsTitle() {
        simulateUserInput("0");
        synchronizingThreads.execute();
        String output = getOutput();
        assertTrue(output.contains("SYNCHRONIZING THREADS"));
        assertTrue(output.contains("1) Synchronized method"));
        assertTrue(output.contains("2) Synchronized block"));
        assertTrue(output.contains("3) Joining threads"));
        assertTrue(output.contains("4) Countdown latch"));
        assertTrue(output.contains("5) Synchronize with semaphore"));
        assertTrue(output.contains("6) Wait and notify methods"));
    }

    @Test
    void getNameShouldReturnSynchronizingThreads() {
        assertEquals("Synchronizing threads", synchronizingThreads.getName());
    }
}