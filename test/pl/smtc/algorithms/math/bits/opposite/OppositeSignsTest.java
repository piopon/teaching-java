package pl.smtc.algorithms.math.bits.opposite;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.smtc.base.BaseTestInOut;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class OppositeSignsTest extends BaseTestInOut {
    private OppositeSigns oppositeSigns;

    @Override
    protected void setUp() {
        oppositeSigns = new OppositeSigns();
    }

    @Test
    void executeShouldInvokeOppositeSignsExample() {
        simulateUserInput("-5" + System.lineSeparator() + "5" + System.lineSeparator());
        oppositeSigns.execute();
        String output = getOutput();
        assertTrue(output.contains("Numbers -5 and 5: OPPOSITE"));
    }

    @Test
    void getNameShouldReturnOppositeSignsString() {
        assertEquals("Check opposite signs", oppositeSigns.getName());
    }

    @ParameterizedTest(name = "{0} and {1} opposite? {2}")
    @MethodSource("oppositeSignsTestData")
    void hasOppositeSignsCorrectlyReturnsOppositeSignCheck(int num1, int num2, boolean result) {
        assertEquals(result, oppositeSigns.hasOppositeSigns(num1, num2));
    }

    private static Stream<Arguments> oppositeSignsTestData() {
        return Stream.of(
                Arguments.of(-100, -100, false),
                Arguments.of(-100, 100, true),
                Arguments.of(100, -100, true),
                Arguments.of(100, 100, false),
                Arguments.of(-5, -5, false),
                Arguments.of(-5, 5, true),
                Arguments.of(5, -5, true),
                Arguments.of(5, 5, false),
                Arguments.of(0, 0, false));
    }
}