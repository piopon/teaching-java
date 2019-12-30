package pl.smtc.basics.flow.examples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.smtc.base.BaseTestInOut;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BoundsDigitsSumTest extends BaseTestInOut {
    private BoundsDigitsSum boundsDigitsSum;

    @Override
    protected void setUp() {
        boundsDigitsSum = new BoundsDigitsSum();
    }

    @Test
    void executeShouldInvokeBoundDigitsSumExample() {
        simulateUserInput("1236");
        boundsDigitsSum.execute();
        String output = getOutput();
        assertTrue(output.contains("First and last digits sum = 7"));
    }

    @Test
    void getNameShouldReturnBoundDigitsSumString() {
        assertEquals("Bound digits sum", boundsDigitsSum.getName());
    }

    @ParameterizedTest(name = "Number {0} - bound digits sum = {1}")
    @MethodSource("digitsSumTestData")
    void sumFirstAndLastDigitShouldReturnCorrectOutput(int number, int digitsSum) {
        assertEquals(digitsSum, boundsDigitsSum.sumFirstAndLastDigit(number));
    }

    private static Stream<Arguments> digitsSumTestData() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 2),
                Arguments.of(8, 16),
                Arguments.of(10, 1),
                Arguments.of(77, 14),
                Arguments.of(115, 6),
                Arguments.of(311, 4),
                Arguments.of(506, 11),
                Arguments.of(1003, 4),
                Arguments.of(1236, 7));
    }
}