package pl.smtc.threads.start.anonymous;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class AnonymousClassTest {
    private AnonymousClass anonymousThread;
    private static final ByteArrayOutputStream OUTPUT_STREAM = new ByteArrayOutputStream();

    @BeforeEach
    void setup() {
        anonymousThread = new AnonymousClass(10,false);
        System.setOut(new PrintStream(OUTPUT_STREAM));
    }

    @AfterEach
    void teardown() {
        System.setIn(System.in);
        System.setOut(System.out);
        OUTPUT_STREAM.reset();
    }

    @Test
    void execute() {
        simulateUserInput(System.lineSeparator() + " " + System.lineSeparator());
        anonymousThread.execute();
        String output = OUTPUT_STREAM.toString();
        assertTrue(output.contains("> second thread is running!"));
        assertTrue(output.contains("> second thread has stopped!"));
    }

    @Test
    void getName() {
        assertEquals("Anonymous class usage", anonymousThread.getName());
    }

    private void simulateUserInput(String simInput) {
        System.setIn(new ByteArrayInputStream(simInput.getBytes()));
    }
}