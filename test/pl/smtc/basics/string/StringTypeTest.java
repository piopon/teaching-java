package pl.smtc.basics.string;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class StringTypeTest extends BaseTestInOut {
    private StringType stringTypeMenu;

    @Override
    protected void setUp() {
        stringTypeMenu = new StringType();
    }

    @Test
    void executeShouldInvokeStringTypeExamplesMenu() {
        simulateCommaInput("0");
        stringTypeMenu.execute();
        String output = getOutput();
        assertTrue(output.contains("STRING TYPE"));
        assertTrue(output.contains("1) String checks"));
        assertTrue(output.contains("2) String conversions"));
        assertTrue(output.contains("3) String inspections"));
        assertTrue(output.contains("4) String transformations"));
    }

    @Test
    void getNameShouldReturnStringTypeString() {
        assertEquals("String type", stringTypeMenu.getName());
    }
}