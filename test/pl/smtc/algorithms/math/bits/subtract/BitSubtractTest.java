package pl.smtc.algorithms.math.bits.subtract;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.smtc.base.BaseTestInOut;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BitSubtractTest extends BaseTestInOut {
    private BitSubtract bitSubtract;

    @Override
    protected void setUp() {
        bitSubtract = new BitSubtract();
    }

    @Test
    void executeShouldInvokeBitSubtractExample() {
        simulateUserInput("10 3" + System.lineSeparator());
        bitSubtract.execute();
        String output = getOutput();
        assertTrue(output.contains("RESULT: 10 - 3 = 7"));
    }

    @Test
    void getNameShouldReturnBitSubtractString() {
        assertEquals("Bit subtract", bitSubtract.getName());
    }

    @ParameterizedTest(name = "Throws when numbers = {0} & {1}")
    @MethodSource("testSubtractThrowData")
    void subtractShouldThrowOnInvalidArguments(int first, int second) {
        assertThrows(IllegalArgumentException.class, () -> bitSubtract.subtract(first, second));
    }

    @ParameterizedTest(name = "{0} - {1} = {2}")
    @MethodSource("bitSubtractTestData")
    void subtractShouldReturnCorrectResult(int first, int second, int result) {
        assertEquals(result, bitSubtract.subtract(first, second));
    }

    private static Stream<Arguments> testSubtractThrowData() {
        return Stream.of(
                Arguments.of(-1, 1),
                Arguments.of(10, -31),
                Arguments.of(-100, -231));
    }

    private static Stream<Arguments> bitSubtractTestData() {
        return Stream.of(
                Arguments.of(0, 0, 0),
                Arguments.of(1, 10, -9),
                Arguments.of(3, 0, 3),
                Arguments.of(5, 1, 4),
                Arguments.of(16, 32, -16),
                Arguments.of(1234, 1000, 234),
                Arguments.of(65307, 7, 65300));
    }
}