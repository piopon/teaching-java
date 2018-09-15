package pl.smtc.recursion.dec2bin;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DecimalToBinaryTest {
    static DecimalToBinary decToBin;

    @BeforeAll
    static void setup() {
        decToBin = new DecimalToBinary();
    }

    @Test
    void getNameShouldReturnDecimalToBinary() {
        String currentName = decToBin.getName();
        assertEquals("Decimal to Binary", currentName);
    }

    @Test
    void decToBinShouldThrowOnNegativeNumbers() {
        String errorMessage = "ERROR: only positive numbers!";
        assertThrows(IllegalArgumentException.class, () -> DecimalToBinary.decToBin(-1), errorMessage);
    }

    @ParameterizedTest(name = "{0} [DEC] = {1} [BIN]")
    @MethodSource("createDecToBinData")
    void decToBinShouldCorrectlyConvertDecimalNumber(int decNumber, String binNumber) {
        assertEquals(binNumber, DecimalToBinary.decToBin(decNumber));
    }

    private static Stream<Arguments> createDecToBinData() {
        return Stream.of(
                Arguments.of(1, "1"),
                Arguments.of(4, "100"),
                Arguments.of(15, "1111"),
                Arguments.of(254, "11111110"),
                Arguments.of(255, "11111111"),
                Arguments.of(256, "100000000"),
                Arguments.of(11111, "10101101100111"),
                Arguments.of(23456, "101101110100000"),
                Arguments.of(65535, "1111111111111111"));
    }
}