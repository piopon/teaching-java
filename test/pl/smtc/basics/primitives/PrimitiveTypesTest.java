package pl.smtc.basics.primitives;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class PrimitiveTypesTest extends BaseTestInOut {
    private PrimitiveTypes primitiveTypes;

    @Override
    protected void setUp() {
        primitiveTypes = new PrimitiveTypes();
    }

    @Test
    void executeShouldInvokePrimitiveTypesExamples() {
        simulateUserInput("0");
        primitiveTypes.execute();
        String output = getOutput();
        assertTrue(output.contains("PRIMITIVE TYPES"));
        assertTrue(output.contains("1) Integral types"));
        assertTrue(output.contains("2) Floating point types"));
        assertTrue(output.contains("3) Character types"));
        assertTrue(output.contains("4) Examples"));
    }

    @Test
    void getNameShouldReturnPrimitiveTypeString() {
        assertEquals("Primitive types",  primitiveTypes.getName());
    }
}