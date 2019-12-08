package pl.smtc.basics.operators;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class OperatorsTest extends BaseTestInOut {
    private Operators operatorsMenu;

    @Override
    protected void setUp() {
        operatorsMenu = new Operators();
    }

    @Test
    void executeShouldInvokeOperatorsMenu() {
        simulateCommaInput("0");
        operatorsMenu.execute();
        String output = getOutput();
        assertTrue(output.contains("OPERATORS"));
        assertTrue(output.contains("1) Arithmetic operators"));
        assertTrue(output.contains("2) Unary operators"));
        assertTrue(output.contains("3) Conditional operators"));
        assertTrue(output.contains("4) Relational operators"));
        assertTrue(output.contains("5) Bitwise operators"));
        assertTrue(output.contains("6) Bit shift operators"));
    }

    @Test
    void getNameShouldReturnOperatorsString() {
        assertEquals("Operators", operatorsMenu.getName());
    }
}