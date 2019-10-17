package pl.smtc.basics.primitives.floating;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class FloatingPointTypesTest extends BaseTestOut {
    FloatingPointTypes floatingPointTypes;

    @Override
    protected void setUp() {
        floatingPointTypes = new FloatingPointTypes();
    }

    @Test
    void executeShouldInvokeFloatingPointTypesExample() {
        floatingPointTypes.execute();
        String output = getOutput();
        assertTrue(output.contains("Float values:"));
        assertTrue(output.contains("- floatValue1 = 10.0"));
        assertTrue(output.contains("- floatValue2 = 20.0"));
        assertTrue(output.contains("- floatValue3 = 30.25"));
        assertTrue(output.contains("Double values:"));
        assertTrue(output.contains("- doubleValue1 = 10.0"));
        assertTrue(output.contains("- doubleValue2 = 20.0"));
        assertTrue(output.contains("- doubleValue3 = 30.25"));
        assertTrue(output.contains("float vs double: 10.0 / 3.0"));
        assertTrue(output.contains("- float  = 3.3333333"));
        assertTrue(output.contains("- double = 3.3333333333333335"));
        assertTrue(output.contains("Floating point types summary"));
        assertTrue(output.contains("size = 32, bytes = 4, min value = 1.401298464324817E-45, max value = 3.4028234663852886E38"));
        assertTrue(output.contains("size = 64, bytes = 8, min value = 4.9E-324, max value = 1.7976931348623157E308"));
    }

    @Test
    void getNameShouldReturnFloatingPointTypesString() {
        assertEquals("Floating point types", floatingPointTypes.getName());
    }
}