package pl.smtc.basics.string.conversions;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class StringConversionsTest extends BaseTestInOut {
    private StringConversions stringConversionsMenu;

    @Override
    protected void setUp() {
        stringConversionsMenu = new StringConversions();
    }

    @Test
    void executeShouldInvokeStringConversionsExamplesMenu() {
        simulateCommaInput("0");
        stringConversionsMenu.execute();
        String output = getOutput();
        assertTrue(output.contains("STRING CONVERSIONS"));
        assertTrue(output.contains("1) Bool to string"));
        assertTrue(output.contains("2) Char(s) to string"));
        assertTrue(output.contains("3) Number to string"));
        assertTrue(output.contains("4) Object to string"));
    }

    @Test
    void getNameShouldReturnStringConversionsString() {
        assertEquals("String conversions", stringConversionsMenu.getName());
    }
}