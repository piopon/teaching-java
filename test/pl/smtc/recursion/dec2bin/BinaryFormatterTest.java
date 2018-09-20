package pl.smtc.recursion.dec2bin;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BinaryFormatterTest {

    @ParameterizedTest(name = "{0} after format = {1}")
    @MethodSource("create4BitsPerGroupData")
    void formatBinShouldCorrectlyFormatBinaryIn4BitsPerGroup(String binRaw, String binFormat) {
        assertEquals(binFormat, BinaryFormatter.formatBin(binRaw, 4));
    }

    private static Stream<Arguments> create4BitsPerGroupData() {
        return Stream.of(
                Arguments.of("1", "0001"),
                Arguments.of("10", "0010"),
                Arguments.of("100", "0100"),
                Arguments.of("1111", "1111"),
                Arguments.of("11111", "0001 1111"),
                Arguments.of("11111110", "1111 1110"),
                Arguments.of("11111111", "1111 1111"),
                Arguments.of("100000000", "0001 0000 0000"),
                Arguments.of("100000000000", "1000 0000 0000"),
                Arguments.of("10101101100111", "0010 1011 0110 0111"),
                Arguments.of("101101110100000", "0101 1011 1010 0000"),
                Arguments.of("1111111111111111", "1111 1111 1111 1111"));
    }

    @ParameterizedTest(name = "{0} after format = {1}")
    @MethodSource("create3BitsPerGroupData")
    void formatBinShouldCorrectlyFormatBinaryIn3BitsPerGroup(String binRaw, String binFormat) {
        assertEquals(binFormat, BinaryFormatter.formatBin(binRaw, 3));
    }

    private static Stream<Arguments> create3BitsPerGroupData() {
        return Stream.of(
                Arguments.of("1", "001"),
                Arguments.of("10", "010"),
                Arguments.of("100", "100"),
                Arguments.of("1111", "001 111"),
                Arguments.of("11111", "011 111"),
                Arguments.of("11111110", "011 111 110"),
                Arguments.of("11111111", "011 111 111"),
                Arguments.of("100000000", "100 000 000"),
                Arguments.of("100000000000", "100 000 000 000"),
                Arguments.of("10101101100111", "010 101 101 100 111"),
                Arguments.of("101101110100000", "101 101 110 100 000"),
                Arguments.of("1111111111111111", "001 111 111 111 111 111"));
    }
}