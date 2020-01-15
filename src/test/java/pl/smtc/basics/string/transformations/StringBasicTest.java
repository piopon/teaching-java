package pl.smtc.basics.string.transformations;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class StringBasicTest extends BaseTestOut {
    private StringBasic stringBasicTransformations;

    @Override
    protected void setUp() {
        stringBasicTransformations = new StringBasic();
    }

    @Test
    void executeShouldInvokeStringBasicExample() {
        stringBasicTransformations.execute();
        String output = getOutput();
        assertTrue(output.contains("Input string:   This is a test string"));
        assertTrue(output.contains("Added string:   This is a test string with const addition."));
        assertTrue(output.contains("Concatenated:   This is a test string with concatenation."));
        assertTrue(output.contains("Lower string:   this is a test string"));
        assertTrue(output.contains("Upped string:   THIS IS A TEST STRING"));
        assertTrue(output.contains("Trimmed string: This is a test string"));
        assertTrue(output.contains("Const joined string: my+test+str"));
        assertTrue(output.contains("Set joined string: set=strings=in"));
    }

    @Test
    void getNameShouldReturnBasicTransformationsString() {
        assertEquals("Basic transformations", stringBasicTransformations.getName());
    }
}