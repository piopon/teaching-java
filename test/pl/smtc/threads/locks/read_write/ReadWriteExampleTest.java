package pl.smtc.threads.locks.read_write;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import java.util.Arrays;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ReadWriteExampleTest extends BaseTestOut {
    ReadWriteExample readWriteLock;

    @Override
    protected void setUp() {
        readWriteLock = new ReadWriteExample(10, 100);
    }

    @Test
    void executeShouldInvokeReadWriteLockExample() {
        readWriteLock.execute();
        String output = getOutput();
        assertTrue(output.contains("MapWriter 1 -> added [testKey, testValue]."));
        assertTrue(output.contains("MapReader 1 -> got value: testValue"));
        assertTrue(output.contains("MapReader 2 -> got value: testValue"));
    }

    @Test
    void getNameShouldReturnReadWriteLockExampleString() {
        assertEquals("Read write lock example", readWriteLock.getName());
    }
}