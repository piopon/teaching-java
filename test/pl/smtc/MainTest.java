package pl.smtc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {
    private Main mainApp;
    private static final ByteArrayOutputStream OUTPUT_STREAM = new ByteArrayOutputStream();

    @BeforeEach
    void setup() {
        mainApp = new Main();
        System.setOut(new PrintStream(OUTPUT_STREAM));
    }

    @AfterEach
    void teardown() {
        System.setOut(System.out);
        OUTPUT_STREAM.reset();
    }

    @Test
    void main() {
        simulateUserInput("0");
        Main.main(new String[]{""});
        String output = OUTPUT_STREAM.toString();
        assertTrue(output.contains("MAIN MENU"));
        assertTrue(output.contains("1) Recursion examples"));
    }

    private void simulateUserInput(String simInput) {
        System.setIn(new ByteArrayInputStream(simInput.getBytes()));
    }
}