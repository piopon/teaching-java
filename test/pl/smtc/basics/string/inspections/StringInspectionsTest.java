package pl.smtc.basics.string.inspections;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class StringInspectionsTest extends BaseTestInOut {
    private StringInspections stringInspectionsMenu;

    @Override
    protected void setUp() {
        stringInspectionsMenu = new StringInspections();
    }

    @Test
    void executeShouldInvokeStringInspectionsExamplesMenu() {
        simulateCommaInput("0");
        stringInspectionsMenu.execute();
        String output = getOutput();
        assertTrue(output.contains("STRING INSPECTIONS"));
        assertTrue(output.contains("1) Basic inspections"));
        assertTrue(output.contains("2) Index searching"));
    }

    @Test
    void getNameShouldReturnStringInspectionsString() {
        assertEquals("String inspections", stringInspectionsMenu.getName());
    }
}