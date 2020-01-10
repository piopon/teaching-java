package pl.smtc.threads.locks.reentrant;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class IncrementValueTest {

    @ParameterizedTest(name = "Start value incremented {0} times = {1}")
    @MethodSource("incrementTestData")
    void incrementShouldIncrementValueInputtedNumberOfTimes(int incrementValue, int resultValue) {
        IncrementValue value = new IncrementValue();
        value.increment(incrementValue);
        assertEquals(resultValue, value.getValue());
    }

    @Test
    void getValueShouldReturnCorrectNumber() {
        IncrementValue value = new IncrementValue();
        assertEquals(0, value.getValue());
    }

    private static Stream<Arguments> incrementTestData() {
        return Stream.of(
                Arguments.of(3, 3),
                Arguments.of(-3, 0),
                Arguments.of(0, 0));
    }
}