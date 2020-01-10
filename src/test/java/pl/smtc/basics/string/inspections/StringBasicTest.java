package pl.smtc.basics.string.inspections;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class StringBasicTest extends BaseTestOut {
    private StringBasic stringBasicInspections;

    @Override
    protected void setUp() {
        stringBasicInspections = new StringBasic();
    }

    @Test
    void executeShouldInvokeStringBasicExample() {
        stringBasicInspections.execute();
        String output = getOutput();
        assertTrue(output.contains("Input string: Test string"));
        assertTrue(output.contains("Input length: 11"));
        assertTrue(output.contains("Canonical: Test string"));
    }

    @Test
    void getNameShouldReturnBasicInspectionsString() {
        assertEquals("Basic inspections", stringBasicInspections.getName());
    }
}