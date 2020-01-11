package pl.smtc.algorithms.math.binomial;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.smtc.base.BaseTestInOut;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BinomialCoefficientTest extends BaseTestInOut {
    private BinomialCoefficient binomialCoefficient;

    @Override
    protected void setUp() {
        binomialCoefficient = new BinomialCoefficient();
    }

    @Test
    void executeShouldInvokeBinomialCoefficientExample() {
        simulateUserInput("5" + System.lineSeparator() + "2" + System.lineSeparator());
        binomialCoefficient.execute();
        String output = getOutput();
        assertTrue(output.contains("C(n,k) = C(5,2) = 10"));
    }

    @Test
    void getNameShouldReturnBinomialCoefficientString() {
        assertEquals("Binomial coefficient", binomialCoefficient.getName());
    }

    @ParameterizedTest(name = "C({0},{1}) = {2}")
    @MethodSource("binomialCorrectTestData")
    void binomialShouldReturnGoodCoefficientIfDataIsCorrect(int n, int k, int result) {
        assertEquals(result, binomialCoefficient.binomial(n, k));
    }

    private static Stream<Arguments> binomialCorrectTestData() {
        return Stream.of(
                Arguments.of(0, 0, 1),
                Arguments.of(1, 0, 1),
                Arguments.of(2, 1, 2),
                Arguments.of(2, 2, 1),
                Arguments.of(3, 3, 1),
                Arguments.of(4, 3, 4),
                Arguments.of(5, 2, 10),
                Arguments.of(7, 6, 7),
                Arguments.of(10, 3, 120),
                Arguments.of(12, 5, 792),
                Arguments.of(14, 7, 3432),
                Arguments.of(15, 8, 6435));
    }
}