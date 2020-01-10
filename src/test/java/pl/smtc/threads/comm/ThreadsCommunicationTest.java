package pl.smtc.threads.comm;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import java.util.concurrent.Callable;

import static org.junit.jupiter.api.Assertions.*;

class ThreadsCommunicationTest extends BaseTestInOut {
    ThreadsCommunication threadsCommunication;

    @Override
    protected void setUp() {
        threadsCommunication = new ThreadsCommunication();
    }

    @Test
    void executeShouldShowUserMenuWithCommunicationExamples() {
        simulateUserInput("0");
        threadsCommunication.execute();
        String output = getOutput();
        assertTrue(output.contains("THREADS COMMUNICATION"));
        assertTrue(output.contains("1) Volatile variable comm "));
        assertTrue(output.contains("2) Implement Callable interface"));
        assertTrue(output.contains("3) Callable and Future"));
        assertTrue(output.contains("4) Producer-consumer pattern"));
        assertTrue(output.contains("5) Low level communication"));
    }

    @Test
    void getNameShouldReturnThreadsCommunication() {
        assertEquals("Threads communication", threadsCommunication.getName());
    }
}