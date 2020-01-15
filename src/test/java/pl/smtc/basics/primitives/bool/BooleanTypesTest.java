package pl.smtc.basics.primitives.bool;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class BooleanTypesTest extends BaseTestOut {
    private BooleanTypes booleanTypes;

    @Override
    protected void setUp() {
        booleanTypes = new BooleanTypes();
    }

    @Test
    void executeShouldInvokeBooleanTypesExample() {
        booleanTypes.execute();
        String output = getOutput();
        assertTrue(output.contains("Boolean values:"));
        assertTrue(output.contains(" - trueValue = true"));
        assertTrue(output.contains(" - falseValue = false"));
    }

    @Test
    void getNameShouldReturnBooleanTypesString() {
        assertEquals("Boolean types", booleanTypes.getName());
    }
}