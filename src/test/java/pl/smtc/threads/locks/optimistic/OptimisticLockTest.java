package pl.smtc.threads.locks.optimistic;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class OptimisticLockTest extends BaseTestOut {
    OptimisticLock optimisticLock;

    @Override
    protected void setUp() {
        optimisticLock = new OptimisticLock(25, 50, 50);
    }

    @Test
    void executeShouldInvokeOptimisticLockExample() {
        optimisticLock.execute();
        String output = getOutput();
        assertTrue(output.contains("FILLER -> run [start]."));
        assertTrue(output.contains("FILLER -> optimistic lock valid? true"));
        assertTrue(output.contains("WRITER -> run [start]."));
        assertTrue(output.contains("WRITER -> write start"));
        assertTrue(output.contains("FILLER -> optimistic lock valid? false"));
        assertTrue(output.contains("WRITER -> run [stop]."));
        assertTrue(output.contains("FILLER -> run [stop]."));
    }

    @Test
    void getNameShouldReturnOptimisticLockExample() {
        assertEquals("Optimistic lock example", optimisticLock.getName());
    }
}