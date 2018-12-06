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
        optimisticLock = new OptimisticLock(15, 20, 20);
    }

    @Test
    void executeShouldInvokeOptimisticLockExample() {
        optimisticLock.execute();
        String output = getOutput();
        String expectedOutput[] = { "FILLER -> run [start].", "FILLER -> optimistic lock valid? true",
            "WRITER -> run [start].", "WRITER -> write start", "FILLER -> optimistic lock valid? false" };
        assertTrue(outputContainsInOrder(output, expectedOutput));
        assertTrue(output.contains("WRITER -> run [stop]."));
        assertTrue(output.contains("FILLER -> run [stop]."));
    }

    @Test
    void getNameShouldReturnOptimisticLockExample() {
        assertEquals("Optimistic lock example", optimisticLock.getName());
    }

    private boolean outputContainsInOrder(String current, String... expected) {
        String orderedOutput = Arrays.stream(expected).collect(Collectors.joining(System.lineSeparator()));
        return current.contains(orderedOutput);
    }
}