package pl.smtc.threads.issues.livelock;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class PoliteWorkerTest extends BaseTestOut {
    private PoliteWorker politeWorker;
    private int workerId = 111;

    @Override
    protected void setUp() {
        politeWorker = new PoliteWorker(workerId, true);
    }

    @Test
    void getNameShouldReturnPoliteWorkerWithId() {
        assertEquals("PoliteWorker " + workerId,politeWorker.getName());
    }

    @Test
    void isActiveShouldReturnTrueAfterCreation() {
        assertEquals(true, politeWorker.isActive());
    }

    @Test
    void doWorkShouldInvokePoliteWorkerIncrementValue() {
        IncrementValue value = new IncrementValue(politeWorker, 0);
        politeWorker.doWork(value, new PoliteWorker(1, false));
        String output = getOutput();
        assertTrue(output.contains(politeWorker.getName() + ": working on increment value object"));
        assertEquals(10, value.getValue());
    }
}