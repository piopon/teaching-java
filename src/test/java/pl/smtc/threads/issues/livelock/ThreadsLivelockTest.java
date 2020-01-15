package pl.smtc.threads.issues.livelock;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class ThreadsLivelockTest extends BaseTestOut {
    ThreadsLivelock livelock;

    @Override
    protected void setUp() {
        livelock = new ThreadsLivelock(3);
    }

    @Test
    void executeShouldInvokeThreadsLivelockExample() {
        livelock.execute();
        String output = getOutput();
        assertTrue(output.contains("> livelock increment value: "));
    }

    @Test
    void getNameShouldReturnThreadsLivelockString() {
        assertEquals("Threads livelock", livelock.getName());
    }
}