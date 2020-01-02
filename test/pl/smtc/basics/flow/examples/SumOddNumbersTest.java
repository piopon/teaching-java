package pl.smtc.basics.flow.examples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.smtc.base.BaseTestInOut;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SumOddNumbersTest extends BaseTestInOut {
    private SumOddNumbers sumOddNumbers;

    @Override
    protected void setUp() {
        sumOddNumbers = new SumOddNumbers();
    }

    @Test
    void executeShouldInvokeSumOddNumbersExample() {
        simulateCommaInput("3, 15");
        sumOddNumbers.execute();
        String output = getOutput();
        assertTrue(output.contains("Sum of odd numbers: 63"));
    }

    @Test
    void getNameShouldReturnSumOddNumbersString() {
        assertEquals("Sum odd numbers", sumOddNumbers.getName());
    }

    @ParameterizedTest(name = "Sum of odd numbers from {0} to {1} = {2}")
    @MethodSource("sumOddTestData")
    void sumOddShouldReturnCorrectResult(int start, int end, int sum) {
        assertEquals(sum, sumOddNumbers.sumOdd(start, end));
    }

    private static Stream<Arguments> sumOddTestData() {
        return Stream.of(
                Arguments.of(-1000, -10, -1),
                Arguments.of(-10, 10, -1),
                Arguments.of(0, 0, 0),
                Arguments.of(0, 1, 1),
                Arguments.of(0, 2, 1),
                Arguments.of(0, 3, 4),
                Arguments.of(1, 3, 4),
                Arguments.of(2, 3, 3),
                Arguments.of(1, 10, 25),
                Arguments.of(4, 21, 117),
                Arguments.of(7, 57, 832),
                Arguments.of(10, 1987, 988011),
                Arguments.of(1, 1991, 992016));
    }
}