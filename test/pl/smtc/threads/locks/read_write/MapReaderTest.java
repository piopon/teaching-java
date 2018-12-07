package pl.smtc.threads.locks.read_write;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static org.junit.jupiter.api.Assertions.*;

class MapReaderTest extends BaseTestOut {
    private MapReader reader;
    private int readerId = 7;
    private String testValue = "testValue";

    @Override
    protected void setUp() {
        Map<String, String> map = new HashMap<>();
        map.put("testKey", testValue);
        reader = new MapReader(readerId, new ReentrantReadWriteLock(), map, 10);
    }

    @Test
    void runInvokesReaderSimAction() {
        reader.run();
        String output = getOutput();
        assertTrue(output.contains("MapReader " + readerId + " -> run [start]"));
        assertTrue(output.contains("MapReader " + readerId + " -> got value: " + testValue));
        assertTrue(output.contains("MapReader " + readerId + " -> run [stop]"));
    }
}