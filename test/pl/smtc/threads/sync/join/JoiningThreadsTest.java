package pl.smtc.threads.sync.join;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class JoiningThreadsTest extends BaseTestInOut {
    JoiningThreads joiningThreads;

    @Override
    protected void setUp() {
        joiningThreads = new JoiningThreads(10, 50, 10);
    }

    @Test
    void executeShouldInvokeFetchProcessAndViewThreads() {
        simulateUserInput(System.lineSeparator());
        joiningThreads.execute();
        String output = getOutput();
        assertTrue(output.contains("ViewDataThread -> run [start]"));
        assertTrue(output.contains("ViewDataThread -> data OK! Viewing it..."));
        assertTrue(output.contains("ViewDataThread -> run [stop]"));
        assertTrue(output.contains("> data process simulation finished!"));
    }

    @Test
    void getNameShouldReturnJoiningThreads() {
        assertEquals("Joining threads", joiningThreads.getName());

    }
}