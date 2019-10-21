package pl.smtc.basics.primitives.examples;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class DefaultValuesTest extends BaseTestOut {
    private DefaultValues defaultValues;

    @Override
    protected void setUp() {
        defaultValues = new DefaultValues();
    }

    @Test
    void executeShouldInvokeDefaultValuesExample() {
        defaultValues.execute();
        String output = getOutput();
        assertTrue(output.contains("Default values:"));
        assertTrue(output.contains("- byte = 0"));
        assertTrue(output.contains("- short = 0"));
        assertTrue(output.contains("- int = 0"));
        assertTrue(output.contains("- long = 0"));
        assertTrue(output.contains("- double = 0.0"));
        assertTrue(output.contains("- float = 0.0"));
        assertTrue(output.contains("- boolean = false"));
        assertTrue(output.contains("- char = \u0000"));
    }

    @Test
    void getNameShouldReturnDefaultValuesString() {
        assertEquals("Default values", defaultValues.getName());
    }
}