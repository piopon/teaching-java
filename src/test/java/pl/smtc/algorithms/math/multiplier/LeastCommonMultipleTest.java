package pl.smtc.algorithms.math.multiplier;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.smtc.base.BaseTestInOut;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LeastCommonMultipleTest extends BaseTestInOut {
    private LeastCommonMultiple lcm;

    @Override
    protected void setUp() {
        lcm = new LeastCommonMultiple();
    }

    @Test
    void executeInvokesLeastCommonMultiplierExample() {
        simulateUserInput("15" + System.lineSeparator() + "20" + System.lineSeparator());
        lcm.execute();
        String output = getOutput();
        assertTrue(output.contains("Least common multiplier of 15 and 20 = 60"));
    }

    @Test
    void getNameReturnsLeastCommonMultiplierString() {
        assertEquals("Least common multiplier", lcm.getName());
    }

    @ParameterizedTest(name = "LCM of {0} and {1} = {2}")
    @MethodSource("lcmTestData")
    void getCalculatesCorrectLeastCommonMultiplier(int num1, int num2, int result) {
        assertEquals(result, lcm.get(num1, num2));
    }

    private static Stream<Arguments> lcmTestData() {
        return Stream.of(
                Arguments.of(5, 2, 10),
                Arguments.of(3, 7, 21),
                Arguments.of(11, 7, 77),
                Arguments.of(4, 5, 20),
                Arguments.of(12, 15, 60),
                Arguments.of(9, 13, 117),
                Arguments.of(65, 10, 130),
                Arguments.of(7, 13, 91),
                Arguments.of(49, 21, 147),
                Arguments.of(17, 13, 221),
                Arguments.of(6, 56, 168),
                Arguments.of(29, 17, 493));
    }
}