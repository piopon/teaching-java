package pl.smtc.threads.locks.stamped;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

import static org.junit.jupiter.api.Assertions.*;

class MapWriterTest extends BaseTestOut {
    MapWriter writer;
    private int writerId = 7;

    @Override
    protected void setUp() {
        Map<Integer, Integer> map = new HashMap<>();
        writer = new MapWriter(writerId, new StampedLock(), map, 10);
    }

    @Test
    void runInvokesWriterSimAction() {
        writer.run();
        String output = getOutput();
        assertTrue(output.contains("MapWriter " + writerId + " -> run [start]"));
        assertTrue(output.contains("MapWriter " + writerId + " -> working..."));
        assertTrue(output.contains("MapWriter " + writerId + " -> added [100, -100]."));
        assertTrue(output.contains("MapWriter " + writerId + " -> run [stop]"));
    }
}