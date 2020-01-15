package pl.smtc.algorithms.math.bits.increment;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.smtc.base.BaseTestInOut;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BitIncrementerTest extends BaseTestInOut {
    private BitIncrementer bitIncrementer;

    @Override
    protected void setUp() {
        bitIncrementer = new BitIncrementer();
    }

    @Test
    void executeShouldInvokeBitIncrementerExample() {
        simulateUserInput("10" + System.lineSeparator());
        bitIncrementer.execute();
        String output = getOutput();
        assertTrue(output.contains("Bit incremented result: 11"));
    }

    @Test
    void getNameShouldReturnBitIncrementerString() {
        assertEquals("Bit incrementer", bitIncrementer.getName());
    }

    @ParameterizedTest(name = "{0} bit incremented = {1}")
    @MethodSource("bitIncrementTestData")
    void incrementShouldAddOneToInputNumber(int input, int result) {
        assertEquals(result, bitIncrementer.increment(input));
    }

    private static Stream<Arguments> bitIncrementTestData() {
        return Stream.of(
                Arguments.of(-767, -768),
                Arguments.of(-11, -12),
                Arguments.of(-3, -4),
                Arguments.of(0, 1),
                Arguments.of(2, 3),
                Arguments.of(54, 55),
                Arguments.of(150, 151));
    }
}