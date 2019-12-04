package pl.smtc.basics.string.inspections;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class StringIndexTest extends BaseTestOut {
    private StringIndex stringIndex;

    @Override
    protected void setUp() {
        stringIndex = new StringIndex();
    }

    @Test
    void executeShouldInvokeStringIndexExample() {
        stringIndex.execute();
        String output = getOutput();
        assertTrue(output.contains("Input string: Test string."));
        assertTrue(output.contains("First char 't' index: 3"));
        assertTrue(output.contains("Next char 't' index: 6"));
        assertTrue(output.contains("First substring index: 2"));
        assertTrue(output.contains("Second substring index: 5"));
        assertTrue(output.contains("Last char 't' index: 6"));
        assertTrue(output.contains("Previous char 't' index: 3"));
        assertTrue(output.contains("Last substring index: 5"));
        assertTrue(output.contains("Previous substring index: 2"));
    }

    @Test
    void getNameShouldReturnIndexSearchingString() {
        assertEquals("Index searching", stringIndex.getName());
    }
}