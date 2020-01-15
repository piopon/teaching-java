package pl.smtc.basics.string.checks;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class StringContentsTest extends BaseTestOut {
    private StringContents stringContents;

    @Override
    protected void setUp() {
        stringContents = new StringContents();
    }

    @Test
    void executeShouldInvokeStringContentsExample() {
        stringContents.execute();
        String output = getOutput();
        assertTrue(output.contains("Input string: Test string"));
        assertTrue(output.contains("Does have 'Test' word: true"));
        assertTrue(output.contains("Is 'i' at pos 8: true"));
        assertTrue(output.contains("Is 'i' at pos 5: false"));
        assertTrue(output.contains("Code point for 'i' correct: true"));
        assertTrue(output.contains("Code point for 'r' correct: true"));
        assertTrue(output.contains("Code sum for test: 2"));
    }

    @Test
    void getNameShouldReturnContentChecksString() {
        assertEquals("Content checks", stringContents.getName());
    }
}