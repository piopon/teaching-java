package pl.smtc.basics.operators.bitwise;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class BitwiseOperatorsTest extends BaseTestInOut {
    private BitwiseOperators bitwiseOperators;

    @Override
    protected void setUp() {
        bitwiseOperators = new BitwiseOperators();
    }

    @Test
    void executeShouldInvokeBitwiseOperatorsExample() {
        simulateUserInput("1234");
        bitwiseOperators.execute();
        String output = getOutput();
        assertTrue(output.contains("Binary input:   00000000000000000000010011010010"));
        assertTrue(output.contains("Binary operand: 00000000000000000000000001111010"));
        assertTrue(output.contains("- bitwise and:  00000000000000000000000001010010"));
        assertTrue(output.contains("- bitwise or:   00000000000000000000010011111010"));
        assertTrue(output.contains("- bitwise xor:  00000000000000000000010010101000"));
        assertTrue(output.contains("- bitwise not:  11111111111111111111101100101101"));
    }

    @Test
    void getNameShouldReturnBitwiseOperatorsString() {
        assertEquals("Bitwise operators", bitwiseOperators.getName());
    }
}