package pl.smtc.threads.issues.slip;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class TestLockTest extends BaseTestOut {
    TestLock testLock;
    String lockName = "test";

    @Override
    protected void setUp() {
        testLock = new TestLock();
    }

    @Test
    void lockInvokesObjectLockMethod() throws InterruptedException {
        testLock.lock(lockName);
        String output = getOutput();
        assertTrue(output.contains(lockName + " -> waiting for lock."));
        assertTrue(output.contains(lockName + " -> lock free."));
        assertTrue(output.contains(lockName + " -> acquired lock."));
    }

    @Test
    void unlockInvokesObjectUnlockMethod() {
        testLock.unlock(lockName);
        String output = getOutput();
        assertTrue(output.contains(lockName + " -> released lock."));
    }
}