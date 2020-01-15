package pl.smtc.threads.locks.stamped;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.StampedLock;

import static org.junit.jupiter.api.Assertions.*;

class MapReaderTest extends BaseTestOut {
    private MapReader reader;
    private int readerId = 17;
    private Integer testValue = -100;

    @Override
    protected void setUp() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(100, testValue);
        reader = new MapReader(readerId, new StampedLock(), map, 10);
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