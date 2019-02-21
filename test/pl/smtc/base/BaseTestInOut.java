package pl.smtc.base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class BaseTestInOut {
    private static final ByteArrayOutputStream OUTPUT_STREAM = new ByteArrayOutputStream();

    @BeforeEach
    void setup() {
        setUp();
        System.setOut(new PrintStream(OUTPUT_STREAM));
    }

    @AfterEach
    void teardown() {
        System.setIn(System.in);
        System.setOut(System.out);
        OUTPUT_STREAM.reset();
    }

    protected abstract void setUp();

    protected String getOutput() {
        return OUTPUT_STREAM.toString();
    }

    protected void simulateUserInput(String simInput) {
        System.setIn(new ByteArrayInputStream(simInput.getBytes()));
    }

    protected void simulateCommaInput(String commaInput) {
        StringBuilder result = new StringBuilder();
        List<String> list = new ArrayList<>(Arrays.asList(commaInput.split(",")));
        for (String currentChar : list) {
            result.append(currentChar.trim()).append(System.lineSeparator());
        }
        simulateUserInput(result.toString());
    }
}
