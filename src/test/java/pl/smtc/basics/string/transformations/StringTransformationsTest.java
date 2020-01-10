package pl.smtc.basics.string.transformations;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class StringTransformationsTest extends BaseTestInOut {
    private StringTransformations stringTransformationsMenu;

    @Override
    protected void setUp() {
        stringTransformationsMenu = new StringTransformations();
    }

    @Test
    void executeShouldInvokeStringTransformationsExamplesMenu() {
        simulateCommaInput("0");
        stringTransformationsMenu.execute();
        String output = getOutput();
        assertTrue(output.contains("STRING TRANSFORMATIONS"));
        assertTrue(output.contains("1) Basic transformations"));
        assertTrue(output.contains("2) Replacing parts"));
        assertTrue(output.contains("3) Splitting string"));
    }

    @Test
    void getNameShouldReturnStringTransformationsString() {
        assertEquals("String transformations", stringTransformationsMenu.getName());
    }
}