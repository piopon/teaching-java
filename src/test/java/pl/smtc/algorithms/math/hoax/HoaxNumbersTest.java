package pl.smtc.algorithms.math.hoax;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.smtc.base.BaseTestInOut;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class HoaxNumbersTest extends BaseTestInOut {
    private HoaxNumbers hoaxNumbers;

    @Override
    protected void setUp() {
        hoaxNumbers = new HoaxNumbers();
    }

    @Test
    void executeShouldInvokeHoaxNumbersExample() {
        simulateUserInput("22" + System.lineSeparator());
        hoaxNumbers.execute();
        String output = getOutput();
        assertTrue(output.contains("Number 22 is a hoax number."));
    }

    @Test
    void getNameShouldReturnHoaxNumbersString() {
        assertEquals("Hoax numbers", hoaxNumbers.getName());
    }

    @ParameterizedTest(name = "Is {0} a hoax number? {1}")
    @MethodSource("hoaxNumbersTestData")
    void isHoaxShouldReturn(int number, boolean result) {
        assertEquals(result, hoaxNumbers.isHoax(number));
    }

    private static Stream<Arguments> hoaxNumbersTestData() {
        return Stream.of(
                Arguments.of(10, false),
                Arguments.of(22, true),
                Arguments.of(80, false),
                Arguments.of(84, true),
                Arguments.of(94, true),
                Arguments.of(100, false),
                Arguments.of(166, true),
                Arguments.of(185, false),
                Arguments.of(278, false),
                Arguments.of(346, true),
                Arguments.of(380, false),
                Arguments.of(382, true));
    }
}