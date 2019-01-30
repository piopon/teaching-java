package pl.smtc.algorithms.math.digits;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.smtc.base.BaseTestInOut;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DigitsSumTest extends BaseTestInOut {
    private DigitsSum digitsSum;

    @Override
    protected void setUp() {
        digitsSum = new DigitsSum();
    }

    @Test
    void execute() {
        simulateUserInput("12345" + System.lineSeparator());
        digitsSum.execute();
        String output = getOutput();
        assertTrue(output.contains("Sum of all digits in 12345 = 15"));
    }

    @Test
    void getName() {
        assertEquals("Sum of all digits", digitsSum.getName());
    }

    @ParameterizedTest(name = "Sum of digits in {0} = {1}")
    @MethodSource("digitsSumTestData")
    void sum(int number, int result) {
        assertEquals(result, digitsSum.sum(number));
    }

    private static Stream<Arguments> digitsSumTestData() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(10, 1),
                Arguments.of(54, 9),
                Arguments.of(79, 16),
                Arguments.of(94, 13),
                Arguments.of(100, 1),
                Arguments.of(166, 13),
                Arguments.of(185, 14),
                Arguments.of(278, 17),
                Arguments.of(346, 13),
                Arguments.of(99380, 29),
                Arguments.of(11111, 5),
                Arguments.of(99999, 45),
                Arguments.of(12382, 16));
    }
}