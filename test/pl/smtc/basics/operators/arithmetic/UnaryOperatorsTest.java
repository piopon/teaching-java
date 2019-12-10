package pl.smtc.basics.operators.arithmetic;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class UnaryOperatorsTest extends BaseTestInOut {
    private UnaryOperators unaryOperators;

    @Override
    protected void setUp() {
        unaryOperators = new UnaryOperators();
    }

    @Test
    void executeShouldInvokeUnaryOperatorsExample() {
        simulateUserInput("11");
        unaryOperators.execute();
        String output = getOutput();
        assertTrue(output.contains("Input value: 11"));
        assertTrue(output.contains("Decrement operator: 10"));
        assertTrue(output.contains("Increment operator: 11"));
        assertTrue(output.contains("Negate expression: -11"));
        assertTrue(output.contains("Input bool value: false"));
        assertTrue(output.contains("Negate bool: true"));
    }

    @Test
    void getNameShouldReturnUnaryOperatorsString() {
        assertEquals("Unary operators", unaryOperators.getName());
    }
}