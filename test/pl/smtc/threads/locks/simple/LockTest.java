package pl.smtc.threads.locks.simple;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LockTest {
    Lock testLock;

    @BeforeEach
    void setup() {
        testLock = new Lock();
    }

    @Test
    void lockShouldLockSimpleLock() throws InterruptedException {
        testLock.lock();
        assertTrue(testLock.isLocked());
    }

    @Test
    void unlockShouldUnlockSimpleLock() {
        testLock.unlock();
        assertFalse(testLock.isLocked());
    }

    @Test
    void isLockedShouldCorrectlyGetInitialLockStatus() {
        assertFalse(testLock.isLocked());
    }
}