package pl.smtc.basics.string.checks;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class StringBasicTest extends BaseTestOut {
    private StringBasic stringBasicChecks;

    @Override
    protected void setUp() {
        stringBasicChecks = new StringBasic();
    }

    @Test
    void executeShouldInvokeStringBasicChecksExample() {
        stringBasicChecks.execute();
        String output = getOutput();
        assertTrue(output.contains("Input string: Test string"));
        assertTrue(output.contains("Input string length: 11"));
        assertTrue(output.contains("In input string empty: false"));
    }

    @Test
    void getNameShouldReturnBasicChecksString() {
        assertEquals("Basic checks", stringBasicChecks.getName());
    }
}