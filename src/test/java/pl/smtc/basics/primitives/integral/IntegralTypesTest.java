package pl.smtc.basics.primitives.integral;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class IntegralTypesTest extends BaseTestOut {
    private IntegralTypes integralTypes;

    @Override
    protected void setUp() {
        integralTypes = new IntegralTypes();
    }

    @Test
    void executeShouldInvokeIntegralTypesExample() {
        integralTypes.execute();
        String output = getOutput();
        assertTrue(output.contains("LONG sum of created integral types: 329930"));
        assertTrue(output.contains("SHORT sum of created integral types: 2250"));
        assertTrue(output.contains("- byte: \tsize = 8, bytes = 1, min value = -128, max value = 127"));
        assertTrue(output.contains("- short: \tsize = 16, bytes = 2, min value = -32768, max value = 32767"));
        assertTrue(output.contains("- int: \tsize = 32, bytes = 4, min value = -2147483648, max value = 2147483647"));
        assertTrue(output.contains("- long: \tsize = 64, bytes = 8, min value = -9223372036854775808, max value = 9223372036854775807"));
    }

    @Test
    void getNameShouldReturnIntegralTypesString() {
        assertEquals("Integral types", integralTypes.getName());
    }
}