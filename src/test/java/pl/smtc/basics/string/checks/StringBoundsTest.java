package pl.smtc.basics.string.checks;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class StringBoundsTest extends BaseTestOut {
    private StringBounds stringBounds;

    @Override
    protected void setUp() {
        stringBounds = new StringBounds();
    }

    @Test
    void executeShouldInvokeStringBoundsExample() {
        stringBounds.execute();
        String output = getOutput();
        assertTrue(output.contains("Input string: My input string"));
        assertTrue(output.contains("Input starts with 'My': true"));
        assertTrue(output.contains("Input starts with 'in': false"));
        assertTrue(output.contains("Offset starts with 'in': true"));
        assertTrue(output.contains("Input ends with 'ring': true"));
        assertTrue(output.contains("Input ends with 'boring': false"));
    }

    @Test
    void getNameShouldReturnBoundariesChecksString() {
        assertEquals("Boundaries checks", stringBounds.getName());
    }
}