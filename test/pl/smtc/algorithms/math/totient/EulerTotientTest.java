package pl.smtc.algorithms.math.totient;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.smtc.base.BaseTestInOut;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class EulerTotientTest extends BaseTestInOut {
    private EulerTotient eulerTotient;

    @Override
    protected void setUp() {
        eulerTotient = new EulerTotient();
    }

    @Test
    void executeShouldInvokeEulerTotientExample() {
        simulateUserInput("9" + System.lineSeparator());
        eulerTotient.execute();
        String output = getOutput();
        assertTrue(output.contains("PHI(9) = 6"));
    }

    @Test
    void getNameShouldReturnEulerTotientString() {
        assertEquals("Euler totient function", eulerTotient.getName());
    }

    @ParameterizedTest(name = "PHI({0}) = {1}")
    @MethodSource("eulerTestData")
    void phiShouldReturnCorrectEulerFunctionResult(int input, int result) {
        assertEquals(result, eulerTotient.phi(input));
    }

    private static Stream<Arguments> eulerTestData() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, 1),
                Arguments.of(3, 2),
                Arguments.of(4, 2),
                Arguments.of(5, 4),
                Arguments.of(7, 6),
                Arguments.of(10, 4),
                Arguments.of(20, 8),
                Arguments.of(23, 22),
                Arguments.of(25, 20),
                Arguments.of(31, 30),
                Arguments.of(50, 20),
                Arguments.of(100, 40),
                Arguments.of(107, 106),
                Arguments.of(123, 80),
                Arguments.of(167, 166),
                Arguments.of(173, 172),
                Arguments.of(174, 56),
                Arguments.of(175, 120),
                Arguments.of(200, 80));
    }
}