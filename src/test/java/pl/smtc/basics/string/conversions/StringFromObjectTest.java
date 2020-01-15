package pl.smtc.basics.string.conversions;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class StringFromObjectTest extends BaseTestOut {
    private StringFromObject stringFromObject;

    @Override
    protected void setUp() {
        stringFromObject = new StringFromObject();
    }

    @Test
    void executeShouldInvokeStingFromObjectExample() {
        stringFromObject.execute();
        String output = getOutput();
        assertTrue(output.contains("TestClass to String: This is TestClass toString() method"));
    }

    @Test
    void getNameShouldReturnObjectToStringString() {
        assertEquals("Object to string", stringFromObject.getName());
    }
}