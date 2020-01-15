package pl.smtc.recursion.power;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestTimerTest {
    static TestTimer testTimer;

    @BeforeAll
    static void setup() {
        testTimer = new TestTimer(Math::pow);
    }

    @Test
    void executeShouldInvokeBiFunctionWithNoException() {
        testTimer.execute(2,3);
    }

    @Test
    void getResultShouldReturnCorrectFunctionResult() {
        testTimer.execute(2,3);
        double expected = 8.0;
        assertEquals(expected, testTimer.getResult().doubleValue());
    }

    @Test
    void getSummaryShouldReturnTimeSummary() {
        testTimer.execute(2,3);
        String expected = "Math::pow: 2.0 ^ 3 = 8.0 [ ";
        assertTrue(testTimer.getSummary("Math::pow").contains(expected));
    }
}