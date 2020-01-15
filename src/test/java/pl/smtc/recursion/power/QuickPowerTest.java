package pl.smtc.recursion.power;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.smtc.base.BaseTestInOut;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class QuickPowerTest extends BaseTestInOut {
    private QuickPower quickPower;

    @Override
    protected void setUp() {
        quickPower = new QuickPower();
    }

    @Test
    void executeShouldOutputNumberRaisedToPowerWithNoCompare() {
        simulateUserInput("3.0 4"+ System.lineSeparator() +"n");
        quickPower.execute();
        String output = getOutput();
        assertTrue(output.contains("RESULT: 3.0 ^ 4 = 81.0"));
    }

    @Test
    void executeShouldOutputNumberRaisedToPowerAdTimeWithCompare() {
        simulateUserInput("3.0 4"+ System.lineSeparator() +"y");
        quickPower.execute();
        String output = getOutput();
        assertTrue(output.contains("Math::pow: 3.0 ^ 4 = 81.0 [ time = "));
        assertTrue(output.contains("this::pow: 3.0 ^ 4 = 81.0 [ time = "));
    }

    @Test
    void getNameShouldReturnRaiseNumberToPower() {
        assertEquals("Raise number to power", quickPower.getName());
    }

    @ParameterizedTest(name = "{0} ^ {1} = {2}")
    @MethodSource("powerTestData")
    void powerReturnsCorrectValue(double base, int exp, double expected) {
        assertEquals(expected, quickPower.power(base, exp));
    }

    private static Stream<Arguments> powerTestData() {
        return Stream.of(
                Arguments.of(1.0, 1, 1.0),
                Arguments.of(2.0, 2, 4.0),
                Arguments.of(5.0, 3, 125.0),
                Arguments.of(10.0, 3, 1000.0));
    }
}