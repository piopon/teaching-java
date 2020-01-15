package pl.smtc.threads.locks.fair;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class FairLockTest extends BaseTestOut {
    private FairLock fairLock;

    @Override
    protected void setUp() {
        fairLock = new FairLock(101);
    }

    @Test
    void executeShouldInvokeFairLockExample() {
        fairLock.execute();
        String output = getOutput();
        assertTrue(output.contains("Thread priority 6 -> count: 100"));
        assertTrue(output.contains("Thread priority 1 -> count: 100"));
        assertTrue(output.contains("Thread priority 10 -> count: 100"));
    }

    @Test
    void getNameShouldReturnFairLockExampleString() {
        assertEquals("Fair lock example", fairLock.getName());
    }
}