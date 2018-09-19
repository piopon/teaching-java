package pl.smtc.recursion.dec2bin;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DecimalToBinaryTest {
    static DecimalToBinary decToBin;
    private static final ByteArrayOutputStream OUTPUT_STREAM = new ByteArrayOutputStream();

    @BeforeAll
    static void setup() {
        decToBin = new DecimalToBinary();
        System.setOut(new PrintStream(OUTPUT_STREAM));
    }

    @AfterAll
    static void tearDown() {
        System.setIn(System.in);
        System.setOut(System.out);
        OUTPUT_STREAM.reset();
    }

    @Test
    void executeShouldOutputWrongNumberErrorIfOutsideRange() {
        simulateUserInput("-1");
        decToBin.execute();
        String output = OUTPUT_STREAM.toString();
        assertTrue(output.contains("ERROR: Wrong number"));
    }

    @Test
    void executeShouldOutputInputtedDecimalAndConvertedBinary() {
        simulateUserInput("15");
        decToBin.execute();
        String output = OUTPUT_STREAM.toString();
        assertTrue(output.contains("DECIMAL: 15 -> BINARY: 1111"));
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
                Arguments.of(617, "1001101001"),
                Arguments.of(899, "1110000011"),
                Arguments.of(1234, "10011010010"),
                Arguments.of(5555, "1010110110011"),
                Arguments.of(11111, "10101101100111"),
                Arguments.of(23456, "101101110100000"),
                Arguments.of(65535, "1111111111111111"));
    }

    private void simulateUserInput(String simInput) {
        System.setIn(new ByteArrayInputStream(simInput.getBytes()));
    }
}