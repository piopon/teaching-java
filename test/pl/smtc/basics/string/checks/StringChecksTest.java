package pl.smtc.basics.string.checks;

import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Equality;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class StringChecksTest extends BaseTestInOut {
    private StringChecks stringChecksMenu;

    @Override
    protected void setUp() {
        stringChecksMenu = new StringChecks();
    }

    @Test
    void executeShouldInvokeStringChecksExamplesMenu() {
        simulateUserInput("0");
        stringChecksMenu.execute();
        String output = getOutput();
        assertTrue(output.contains("STRING CHECKS"));
        assertTrue(output.contains("1) Basic checks"));
        assertTrue(output.contains("2) Equality checks"));
        assertTrue(output.contains("3) Boundaries checks"));
        assertTrue(output.contains("4) Content checks"));
        assertTrue(output.contains("5) Regex matchers"));
    }

    @Test
    void getNameShouldReturnStringChecksString() {
        assertEquals("String checks", stringChecksMenu.getName());
    }
}