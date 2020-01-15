package pl.smtc.basics.string.transformations;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class StringReplaceTest extends BaseTestOut {
    private StringReplace stringReplace;

    @Override
    protected void setUp() {
        stringReplace = new StringReplace();
    }

    @Test
    void executeShouldInvokeStringReplaceExample() {
        stringReplace.execute();
        String output = getOutput();
        assertTrue(output.contains("Input string: This is a test string"));
        assertTrue(output.contains("Char replace: This_is_a_test_string"));
        assertTrue(output.contains("String replace: This is a final string"));
        assertTrue(output.contains("First replace: Thisis a test string"));
        assertTrue(output.contains("All replace: Thisisateststring"));
    }

    @Test
    void getNameShouldReturnReplacingPartsString() {
        assertEquals("Replacing parts", stringReplace.getName());
    }
}