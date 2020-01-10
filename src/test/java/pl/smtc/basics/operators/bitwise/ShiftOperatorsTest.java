package pl.smtc.basics.operators.bitwise;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class ShiftOperatorsTest extends BaseTestInOut {
    private ShiftOperators shiftOperators;

    @Override
    protected void setUp() {
        shiftOperators = new ShiftOperators();
    }

    @Test
    void executeShouldInvokeShiftOperatorsExample() {
        simulateUserInput("4321");
        shiftOperators.execute();
        String output = getOutput();
        assertTrue(output.contains("Binary input:    00000000000000000001000011100001"));
        assertTrue(output.contains("- shift left:    00000000010000111000010000000000"));
        assertTrue(output.contains("- shift right:   00000000000000000000000000000100"));
        assertTrue(output.contains("- u shift right: 00000000000000000000000000000100"));
    }

    @Test
    void getNameShouldReturnShiftOperatorsString() {
        assertEquals("Bit shift operators", shiftOperators.getName());
    }
}