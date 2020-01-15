package pl.smtc.basics.string.checks;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class StringEqualsTest extends BaseTestOut {
    private StringEquals stringEquals;

    @Override
    protected void setUp() {
        stringEquals = new StringEquals();
    }

    @Test
    void executeShouldInvokeStringEqualsExample() {
        stringEquals.execute();
        String output = getOutput();
        assertTrue(output.contains("Input string: Test string"));
        assertTrue(output.contains("Is input equal to 'Test string': true"));
        assertTrue(output.contains("Is input equal to 'Test String': false"));
        assertTrue(output.contains("Is input equal to 'Test String' (ignore case): true"));
        assertTrue(output.contains("Is content equal to 'Test string': true"));
        assertTrue(output.contains("Is buffer equal to 'Test string': true"));
        assertTrue(output.contains("Comparing to 'Test string': 0"));
        assertTrue(output.contains("Comparing to 'TEST STRING': 32"));
        assertTrue(output.contains("Comparing to 'TEST STRING' (ignore case): 0"));
    }

    @Test
    void getNameShouldReturnEqualityChecks() {
        assertEquals("Equality checks", stringEquals.getName());
    }
}