package pl.smtc.basics.string.conversions;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class StringFromBoolTest extends BaseTestOut {
    private StringFromBool stringFromBool;

    @Override
    protected void setUp() {
        stringFromBool = new StringFromBool();
    }

    @Test
    void executeShouldInvokeStingFromBoolExample() {
        stringFromBool.execute();
        String output = getOutput();
        assertTrue(output.contains("Boolean 'true' to String: true"));
        assertTrue(output.contains("Boolean 'false' to String: false"));
    }

    @Test
    void getNameShouldReturnBoolToStringString() {
        assertEquals("Bool to string", stringFromBool.getName());
    }
}