package pl.smtc.basics.operators.relational;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class RelationalOperatorsTest extends BaseTestInOut {
    private RelationalOperators relationalOperators;

    @Override
    protected void setUp() {
        relationalOperators = new RelationalOperators();
    }

    @Test
    void executeShouldInvokeRelationalOperatorsExample() {
        simulateUserInput("9");
        relationalOperators.execute();
        String output = getOutput();
        assertTrue(output.contains("Is 9 == 10? false"));
        assertTrue(output.contains("Is 9 != 10? true"));
        assertTrue(output.contains("Is 9 > 10? false"));
        assertTrue(output.contains("Is 9 >= 10? false"));
        assertTrue(output.contains("Is 9 < 10? true"));
        assertTrue(output.contains("Is 9 <= 10? true"));
    }

    @Test
    void getNameShouldReturnRelationalOperatorsString() {
        assertEquals("Relational operators", relationalOperators.getName());
    }
}