package pl.smtc.algorithms.math.primes.factor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.smtc.base.BaseTestInOut;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PrimeFactorsTest extends BaseTestInOut {
    private PrimeFactors primeFactors;

    @Override
    protected void setUp() {
        primeFactors = new PrimeFactors();
    }

    @Test
    void executeShouldInvokePrimeFactorsExample() {
        simulateUserInput("84" + System.lineSeparator());
        primeFactors.execute();
        String output = getOutput();
        assertTrue(output.contains("Prime factors: [2, 3, 7]"));
    }

    @Test
    void getNameShouldReturnPrimeFactorsString() {
        assertEquals("Prime factors", primeFactors.getName());
    }

    @ParameterizedTest(name = "{0}: prime factors = {1}")
    @MethodSource("primeFactorsTestData")
    void getFactorsReturnsPrimeFactorsOfInputtedNumber(int number, List<Integer> result) {
        assertEquals(result, primeFactors.getFactors(number));
    }

    private static Stream<Arguments> primeFactorsTestData() {
        return Stream.of(
                Arguments.of(2, Arrays.asList(2)),
                Arguments.of(3, Arrays.asList(3)),
                Arguments.of(20, Arrays.asList(2, 5)),
                Arguments.of(32, Arrays.asList(2)),
                Arguments.of(63, Arrays.asList(3, 7)),
                Arguments.of(94, Arrays.asList(2, 47)),
                Arguments.of(100, Arrays.asList(2, 5)),
                Arguments.of(103, Arrays.asList(103)),
                Arguments.of(105, Arrays.asList(3, 5, 7)),
                Arguments.of(114, Arrays.asList(2, 3, 19)),
                Arguments.of(116, Arrays.asList(2, 29)),
                Arguments.of(358, Arrays.asList(2, 179)),
                Arguments.of(390, Arrays.asList(2, 3, 5, 13)),
                Arguments.of(429, Arrays.asList(3, 11, 13)),
                Arguments.of(784, Arrays.asList(2, 7)),
                Arguments.of(984, Arrays.asList(2, 3, 41)),
                Arguments.of(999, Arrays.asList(3, 37)),
                Arguments.of(1325, Arrays.asList(5, 53)),
                Arguments.of(5382, Arrays.asList(2, 3, 13, 23)));
    }
}