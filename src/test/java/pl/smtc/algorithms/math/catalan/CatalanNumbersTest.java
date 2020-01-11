package pl.smtc.algorithms.math.catalan;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.smtc.base.BaseTestInOut;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CatalanNumbersTest extends BaseTestInOut {
    private CatalanNumbers catalanNumbers;

    @Override
    protected void setUp() {
        catalanNumbers = new CatalanNumbers();
    }

    @Test
    void executeShouldInvokeCatalanNumbersExample() {
        simulateUserInput("5" + System.lineSeparator());
        catalanNumbers.execute();
        String output = getOutput();
        assertTrue(output.contains("How many catalan numbers to print:"));
        assertTrue(output.contains("C(0) = 1"));
        assertTrue(output.contains("C(1) = 1"));
        assertTrue(output.contains("C(2) = 2"));
        assertTrue(output.contains("C(3) = 5"));
        assertTrue(output.contains("C(4) = 14"));
    }

    @Test
    void getNameShouldReturnCatalanNumbersString() {
        assertEquals("Catalan numbers", catalanNumbers.getName());
    }

    @ParameterizedTest(name = "C({0}) = {1}")
    @MethodSource("catalanNumbersTestData")
    void catalanShouldReturnCorrectCatalanNumber(int n, int result) {
        assertEquals(result, catalanNumbers.catalan(n));
    }

    private static Stream<Arguments> catalanNumbersTestData() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(1, 1),
                Arguments.of(2, 2),
                Arguments.of(3, 5),
                Arguments.of(4, 14),
                Arguments.of(6, 132),
                Arguments.of(8, 1430),
                Arguments.of(10, 16796),
                Arguments.of(12, 208012));
    }
}