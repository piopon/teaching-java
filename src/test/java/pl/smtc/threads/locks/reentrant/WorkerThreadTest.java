package pl.smtc.threads.locks.reentrant;

import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static org.junit.jupiter.api.Assertions.*;

class WorkerThreadTest {

    @Test
    void runShouldInvokeWorkerThreadAndIncrementValue() {
        Lock lock = new ReentrantLock();
        IncrementValue value = new IncrementValue();
        WorkerThread worker = new WorkerThread(1, lock, value, 7);
        worker.run();
        assertEquals(7, value.getValue());
    }
}