package pl.smtc.threads.locks.read_write;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;
import pl.smtc.base.BaseTestOut;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static org.junit.jupiter.api.Assertions.*;

class MapWriterTest extends BaseTestOut {
    MapWriter writer;
    private int writerId = 7;

    @Override
    protected void setUp() {
        Map<String, String> map = new HashMap<>();
        writer = new MapWriter(writerId, new ReentrantReadWriteLock(), map, 10);
    }

    @Test
    void runInvokesWriterSimAction() {
        writer.run();
        String output = getOutput();
        assertTrue(output.contains("MapWriter " + writerId + " -> run [start]"));
        assertTrue(output.contains("MapWriter " + writerId + " -> working..."));
        assertTrue(output.contains("MapWriter " + writerId + " -> added [testKey, testValue]."));
        assertTrue(output.contains("MapWriter " + writerId + " -> run [stop]"));
    }
}