package pl.smtc.algorithms.math.bits.converter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.smtc.base.BaseTestInOut;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FormatConverterTest extends BaseTestInOut {
    private FormatConverter formatConverter;

    @Override
    protected void setUp() {
        formatConverter = new FormatConverter();
    }

    @Test
    void executeShouldInvokeBitsConverterExample() {
        simulateUserInput("16" + System.lineSeparator());
        formatConverter.execute();
        String output = getOutput();
        assertTrue(output.contains("* BIN: 00010000"));
        assertTrue(output.contains("* OCT: 20"));
        assertTrue(output.contains("* HEX: 0x10"));
    }

    @Test
    void getNameShouldReturnBitsConverterString() {
        assertEquals("Format converter", formatConverter.getName());
    }

    @ParameterizedTest(name = "{0} -> BIN: {1}")
    @MethodSource("binTestData")
    void printBinShouldOutputCorrectBinaryFormat(int input, String result) {
        assertEquals(result, formatConverter.printBin(input));
    }

    @ParameterizedTest(name = "{0} -> OCT: {1}")
    @MethodSource("octTestData")
    void printOctShouldOutputCorrectOctalFormat(int input, String result) {
        assertEquals(result, formatConverter.printOct(input));
    }

    @ParameterizedTest(name = "{0} -> HEX: {1}")
    @MethodSource("hexTestData")
    void printHexShouldOutputCorrectHexadecimalFormat(int input, String result) {
        assertEquals(result, formatConverter.printHex(input));
    }

    private static Stream<Arguments> binTestData() {
        return Stream.of(
                Arguments.of(1, "0001"),
                Arguments.of(22, "00010110"),
                Arguments.of(121, "01111001"),
                Arguments.of(9999, "0010011100001111"),
                Arguments.of(12345, "0011000000111001"));
    }

    private static Stream<Arguments> octTestData() {
        return Stream.of(
                Arguments.of(5, "5"),
                Arguments.of(17, "21"),
                Arguments.of(654, "1216"),
                Arguments.of(7890, "17322"),
                Arguments.of(54321, "152061"));
    }

    private static Stream<Arguments> hexTestData() {
        return Stream.of(
                Arguments.of(8, "0x8"),
                Arguments.of(13, "0xD"),
                Arguments.of(164, "0xA4"),
                Arguments.of(5371, "0x14FB"),
                Arguments.of(71830, "0x11896"));
    }
}