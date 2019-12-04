package pl.smtc.basics.string.conversions;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class StringFromCharsTest extends BaseTestOut {
    private StringFromChars stringFromChars;

    @Override
    protected void setUp() {
        stringFromChars = new StringFromChars();
    }

    @Test
    void executeShouldInvokeStingFromCharsExample() {
        stringFromChars.execute();
        String output = getOutput();
        assertTrue(output.contains("Char 'a' to String: a"));
        assertTrue(output.contains("Chars 'ab' to String: ab"));
        assertTrue(output.contains("Char 'bc' to String: bc"));
    }

    @Test
    void getNameShouldReturnCharsToStringString() {
        assertEquals("Char(s) to string", stringFromChars.getName());
    }
}