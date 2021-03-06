package pl.smtc.threads.start.anonymous;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class AnonymousClassTest extends BaseTestInOut {
    private AnonymousClass anonymousThread;

    @Override
    protected void setUp() {
        anonymousThread = new AnonymousClass(3,false);
    }

    @Test
    void executeShouldRunAnonymousThreadExample() {
        simulateUserInput(System.lineSeparator() + " " + System.lineSeparator());
        anonymousThread.execute();
        String output = getOutput();
        assertTrue(output.contains("> second thread is running!"));
        assertTrue(output.contains("> second thread has stopped!"));
    }

    @Test
    void getNameShouldReturnAnonymousClassUsage() {
        assertEquals("Anonymous class usage", anonymousThread.getName());
    }
}