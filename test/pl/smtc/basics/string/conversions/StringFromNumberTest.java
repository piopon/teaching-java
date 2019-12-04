package pl.smtc.basics.string.conversions;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class StringFromNumberTest extends BaseTestOut {
    private StringFromNumber stringFromNumber;

    @Override
    protected void setUp() {
        stringFromNumber = new StringFromNumber();
    }

    @Test
    void executeShouldInvokeStingFromNumberExample() {
        stringFromNumber.execute();
        String output = getOutput();
        assertTrue(output.contains("Double to String: 3.71"));
        assertTrue(output.contains("Float to String: 10.23"));
        assertTrue(output.contains("Integer to String: 987"));
        assertTrue(output.contains("Long to String: 100"));
    }

    @Test
    void getNameShouldReturnNumberToStringString() {
        assertEquals("Number to string", stringFromNumber.getName());
    }
}