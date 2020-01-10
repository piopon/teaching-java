package pl.smtc.basics.flow.examples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.smtc.base.BaseTestInOut;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PerfectNumberTest extends BaseTestInOut {
    private PerfectNumber perfectNumber;

    @Override
    protected void setUp() {
        perfectNumber = new PerfectNumber();
    }

    @Test
    void executeShouldInvokePerfectNumberExample() {
        simulateCommaInput("29");
        perfectNumber.execute();
        String output = getOutput();
        assertTrue(output.contains("Number 29 IS NOT a perfect number"));
    }

    @Test
    void getNameShouldReturnPerfectNumberString() {
        assertEquals("Perfect number", perfectNumber.getName());
    }

    @ParameterizedTest(name = "Is {0} a perfect number? {1}")
    @MethodSource("isPerfectNumberTestData")
    void isPerfectNumberShouldReturnCorrectResult(int number, boolean expected) {
        assertEquals(expected, perfectNumber.isPerfectNumber(number));
    }

    private static Stream<Arguments> isPerfectNumberTestData() {
        return Stream.of(
                Arguments.of(-6, false),
                Arguments.of(-1, false),
                Arguments.of(0, false),
                Arguments.of(1, false),
                Arguments.of(6, true),
                Arguments.of(11, false),
                Arguments.of(28, true),
                Arguments.of(292, false),
                Arguments.of(496, true),
                Arguments.of(731, false),
                Arguments.of(1111, false),
                Arguments.of(2331, false),
                Arguments.of(8128, true),
                Arguments.of(15735, false));
    }
}