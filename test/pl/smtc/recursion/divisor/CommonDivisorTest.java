package pl.smtc.recursion.divisor;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CommonDivisorTest {
    private CommonDivisor commonDivisor;
    private static final ByteArrayOutputStream OUTPUT_STREAM = new ByteArrayOutputStream();

    @BeforeEach
    void setup() {
        commonDivisor = new CommonDivisor();
        System.setOut(new PrintStream(OUTPUT_STREAM));
    }

    @AfterEach
    void teardown() {
        System.setIn(System.in);
        System.setOut(System.out);
        OUTPUT_STREAM.reset();
    }

    @Test
    void executeShouldOutputCorrectDivisorOfTwoInputtedNumbers() {
        simulateUserInput("7 56");
        commonDivisor.execute();
        String output = OUTPUT_STREAM.toString();
        assertTrue(output.contains("Greatest common divisor of 7 and 56 is:"));
        assertTrue(output.contains("  +-- 7 [recursion]"));
        assertTrue(output.contains("  +-- 7 [in a loop]"));
    }

    @Test
    void getNameShouldReturnGreatestCommonDivisor() {
        assertEquals("Greatest common divisor", commonDivisor.getName());
    }

    @Test
    void greatestCommonDivisorShouldThrowOnZeroNumbers() {
        String errorMessage = "ERROR! Cannot find GCD of 0 and 0 ...";
        assertThrows(IllegalArgumentException.class, () -> commonDivisor.greatestCommonDivisor(0, 0), errorMessage);
    }

    @Test
    void greatestCommonDivisorLoopShouldThrowOnZeroNumbers() {
        String errorMessage = "ERROR! Cannot find GCD of 0 and 0 ...";
        assertThrows(IllegalArgumentException.class, () -> commonDivisor.greatestCommonDivisorLoop(0, 0), errorMessage);
    }

    @ParameterizedTest(name = "GCD of {0} and {1} equals {2}")
    @MethodSource("gcdTestData")
    void greatestCommonDivisorReturnsCorrectValue(int number1, int number2, int result) {
        assertEquals(result, commonDivisor.greatestCommonDivisor(number1, number2));
    }

    @ParameterizedTest(name = "GCD of {0} and {1} equals {2}")
    @MethodSource("gcdTestData")
    void greatestCommonDivisorLoopReturnsCorrectValue(int number1, int number2, int result) {
        assertEquals(result, commonDivisor.greatestCommonDivisorLoop(number1, number2));
    }

    private static Stream<Arguments> gcdTestData() {
        return Stream.of(
                Arguments.of(-10, -55, 5),
                Arguments.of(-5, 35, 5),
                Arguments.of(0, 9, 9),
                Arguments.of(1, 1, 1),
                Arguments.of(5, -35, 5),
                Arguments.of(9, 6, 3),
                Arguments.of(10, 7, 1),
                Arguments.of(12, 15, 3),
                Arguments.of(21, 77, 7),
                Arguments.of(25, 15, 5),
                Arguments.of(36, 48, 12),
                Arguments.of(50, 50, 50),
                Arguments.of(100, 10, 10),
                Arguments.of(235, 210, 5),
                Arguments.of(1000, 35, 5));
    }

    private void simulateUserInput(String simInput) {
        System.setIn(new ByteArrayInputStream(simInput.getBytes()));
    }
}