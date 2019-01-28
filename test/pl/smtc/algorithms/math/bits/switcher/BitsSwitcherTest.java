package pl.smtc.algorithms.math.bits.switcher;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.smtc.base.BaseTestInOut;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BitsSwitcherTest extends BaseTestInOut {
    private BitsSwitcher bitsSwitcher;

    @Override
    protected void setUp() {
        bitsSwitcher = new BitsSwitcher();
    }

    @Test
    void executeShouldInvokeBitsSwitcherExample() {
        simulateUserInput("200 5 3" + System.lineSeparator());
        bitsSwitcher.execute();
        String output = getOutput();
        assertTrue(output.contains("11001000 [BIN] <-> 200 [DEC]"));
        assertTrue(output.contains("11101000 [BIN] <-> 232 [DEC]"));
        assertTrue(output.contains("11100000 [BIN] <-> 224 [DEC]"));

    }

    @Test
    void getNameShouldReturnBitsSwitcherString() {
        assertEquals("Bits switcher", bitsSwitcher.getName());
    }

    @Test
    void turnOnShouldThrowExceptionIfWrongBitNumber() {
        assertThrows(IllegalArgumentException.class, () -> bitsSwitcher.turnOn(-1, 1));
    }

    @ParameterizedTest(name = "{0} after bit {1} on  = {2}")
    @MethodSource("turnOnBitTestData")
    void turnOnShouldSwitchSpecifiedBitTo1(int input, int bitNo, int result) {
        assertEquals(result, bitsSwitcher.turnOn(bitNo, input));
    }

    @Test
    void turnOffShouldThrowExceptionIfWrongBitNumber() {
        assertThrows(IllegalArgumentException.class, () -> bitsSwitcher.turnOff(-1, 1));
    }

    @ParameterizedTest(name = "{0} after bit {1} off  = {2}")
    @MethodSource("turnOffBitTestData")
    void turnOffShouldSwitchSpecifiedBitTo0(int input, int bitNo, int result) {
        assertEquals(result, bitsSwitcher.turnOff(bitNo, input));
    }

    private static Stream<Arguments> turnOnBitTestData() {
        return Stream.of(
                Arguments.of(5, 1, 7),
                Arguments.of(16, 3, 24),
                Arguments.of(231, 3, 239),
                Arguments.of(1234, 5, 1266),
                Arguments.of(65341, 7, 65469));
    }

    private static Stream<Arguments> turnOffBitTestData() {
        return Stream.of(
                Arguments.of(3, 1, 1),
                Arguments.of(16, 4, 0),
                Arguments.of(231, 5, 199),
                Arguments.of(1234, 6, 1170),
                Arguments.of(65341, 10, 64317));
    }
}