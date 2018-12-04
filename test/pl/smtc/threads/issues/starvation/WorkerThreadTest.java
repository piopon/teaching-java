package pl.smtc.threads.issues.starvation;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class WorkerThreadTest extends BaseTestOut {
    private WorkerThread workerThread;
    private String workerTestName = "testWorkerThread";

    @Override
    protected void setUp() {
        Object lock = new Object();
        workerThread = new WorkerThread(workerTestName, 5, lock);
    }

    @Test
    void runTriggersWorkerThreadExecution() {
        workerThread.run();
        String output = getOutput();
        assertTrue(output.contains(workerTestName + " -> executionTime: "));
    }
}