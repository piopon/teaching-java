package pl.smtc.basics.operators.relational;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class ConditionalOperatorsTest extends BaseTestOut {
    private ConditionalOperators conditionalOperators;

    @Override
    protected void setUp() {
        conditionalOperators = new ConditionalOperators();
    }

    @Test
    void executeShouldInvokeConditionalOperatorsExample() {
        conditionalOperators.execute();
        String output = getOutput();
        assertTrue(output.contains("Operator AND: true && false = false"));
        assertTrue(output.contains("Operator OR: true || false = true"));
        assertTrue(output.contains("Ternary operator: OR operator is true"));
    }

    @Test
    void getNameShouldReturnConditionalOperatorsString() {
        assertEquals("Conditional operators", conditionalOperators.getName());
    }
}