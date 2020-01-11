package pl.smtc.algorithms.math.bits.gray;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.smtc.base.BaseTestInOut;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GrayCodeTest extends BaseTestInOut {
    private GrayCode grayCode;

    @Override
    protected void setUp() {
        grayCode = new GrayCode();
    }

    @Test
    void executeShouldInvokeGrayCodeGeneratorString() {
        simulateUserInput("3" + System.lineSeparator());
        grayCode.execute();
        String output = getOutput();
        assertTrue(output.contains("3 BIT GRAY CODE"));
        assertTrue(output.contains("000"));
        assertTrue(output.contains("001"));
        assertTrue(output.contains("011"));
        assertTrue(output.contains("010"));
        assertTrue(output.contains("110"));
        assertTrue(output.contains("111"));
        assertTrue(output.contains("101"));
        assertTrue(output.contains("100"));
    }

    @Test
    void getNameShouldReturnGrayCodeGeneratorString() {
        assertEquals("Gray code generator", grayCode.getName());
    }

    @ParameterizedTest(name = "{0} bit gray code = {1}")
    @MethodSource("getGrayCodeTestData")
    void getGrayCodeShouldCorrectlyGenerateGrayCode(int size, List<String> result) {
        assertEquals(result, grayCode.getGrayCode(size));
    }

    private static Stream<Arguments> getGrayCodeTestData() {
        return Stream.of(
                Arguments.of(1, Arrays.asList("0","1")),
                Arguments.of(2, Arrays.asList("00","01","11","10")),
                Arguments.of(3, Arrays.asList("000","001","011","010","110","111","101","100")));
    }

    @Test
    void getGrayCodeShouldThrowIfInvalidArgumentWasInputted() {
        assertThrows(IllegalArgumentException.class, () -> grayCode.getGrayCode(0));
    }
}