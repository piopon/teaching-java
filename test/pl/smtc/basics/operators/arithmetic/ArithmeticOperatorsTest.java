package pl.smtc.basics.operators.arithmetic;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticOperatorsTest extends BaseTestInOut {
    private ArithmeticOperators arithmeticOperators;

    @Override
    protected void setUp() {
        arithmeticOperators = new ArithmeticOperators();
    }

    @Test
    void executeShouldInvokeArithmeticOperatorsExample() {
        simulateUserInput("7");
        arithmeticOperators.execute();
        String output = getOutput();
        assertTrue(output.contains("7 + 5 = 12"));
        assertTrue(output.contains("12 - 1 = 11"));
        assertTrue(output.contains("11 * 2 = 22"));
        assertTrue(output.contains("22 / 2 = 11"));
        assertTrue(output.contains("11 + 8 = 19"));
        assertTrue(output.contains("19 % 7 = 5"));
    }

    @Test
    void getNameShouldReturnArithmeticOperatorsString() {
        assertEquals("Arithmetic operators", arithmeticOperators.getName());
    }
}