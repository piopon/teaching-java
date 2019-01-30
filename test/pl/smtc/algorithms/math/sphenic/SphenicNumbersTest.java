package pl.smtc.algorithms.math.sphenic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.smtc.base.BaseTestInOut;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SphenicNumbersTest extends BaseTestInOut {
    private SphenicNumbers sphenicNumbers;

    @Override
    protected void setUp() {
        sphenicNumbers = new SphenicNumbers();
    }

    @Test
    void executeShouldInvokeSphenicNumbersExample() {
        simulateUserInput("35" + System.lineSeparator());
        sphenicNumbers.execute();
        String output = getOutput();
        assertTrue(output.contains("Number 35 is NOT a sphenic number."));
    }

    @Test
    void getNameShouldReturnHoaxNumbersString() {
        assertEquals("Sphenic numbers", sphenicNumbers.getName());
    }

    @ParameterizedTest(name = "Is {0} a sphenic number? {1}")
    @MethodSource("sphenicNumbersTestData")
    void isSphenicShouldReturnCorrectResult(int number, boolean result) {
        assertEquals(result, sphenicNumbers.isSphenic(number));
    }

    private static Stream<Arguments> sphenicNumbersTestData() {
        return Stream.of(
                Arguments.of(3, false),
                Arguments.of(22, false),
                Arguments.of(30, true),
                Arguments.of(42, true),
                Arguments.of(54, false),
                Arguments.of(66, true),
                Arguments.of(69, false),
                Arguments.of(70, true),
                Arguments.of(75, false),
                Arguments.of(78, true),
                Arguments.of(185, false),
                Arguments.of(382, false));
    }
}