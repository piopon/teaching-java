package pl.smtc.threads.locks.fair;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static org.junit.jupiter.api.Assertions.*;

class WorkerThreadTest extends BaseTestOut {
    private WorkerThread workerThread;
    private String workerName = "testWorker";

    @Override
    protected void setUp() {
        Lock lock = new ReentrantLock(true);
        workerThread = new WorkerThread(lock, workerName, 201);
    }

    @Test
    void runShouldInvokeWorkerThreadAction() {
        workerThread.run();
        String output = getOutput();
        assertTrue(output.contains(workerName + " -> count: 0"));
        assertTrue(output.contains(workerName + " -> count: 100"));
        assertTrue(output.contains(workerName + " -> count: 200"));
    }
}