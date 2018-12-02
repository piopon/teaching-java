package pl.smtc.threads.issues.deadlock;

import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static org.junit.jupiter.api.Assertions.*;

class TestLockTest {

    @Test
    void getNameShouldReturnNameFromConstructor() {
        String testName = "TestLockTestName";
        TestLock testLock = new TestLock(testName, null);
        assertEquals(testName, testLock.getName());
    }

    @Test
    void getLockShouldReturnLockFromConstructor() {
        Lock lock = new ReentrantLock();
        TestLock testLock = new TestLock(null, lock);
        assertEquals(lock, testLock.getLock());
    }
}