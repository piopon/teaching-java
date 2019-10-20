package pl.smtc.basics.primitives.examples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.smtc.base.BaseTestInOut;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class KilobytesConverterTest extends BaseTestInOut {
    private KilobytesConverter kilobytesConverter;

    @Override
    protected void setUp() {
        kilobytesConverter = new KilobytesConverter();
    }

    @ParameterizedTest(name = "{0}KB = {1}MB, {2}KB")
    @MethodSource("kilobytesConverterData")
    void executeShouldInvokeKilobytesConverterExample(String input, String megaBytes, String restBytes) {
        simulateUserInput(input);
        kilobytesConverter.execute();
        String output = getOutput();
        assertTrue(output.contains(input + " KB = " + megaBytes + " MB and " + restBytes + " KB"));
    }

    private static Stream<Arguments> kilobytesConverterData() {
        return Stream.of(
                Arguments.of("0", "0", "0"),
                Arguments.of("1", "0", "1"),
                Arguments.of("1023", "0", "1023"),
                Arguments.of("1024", "1", "0"),
                Arguments.of("1025", "1", "1"),
                Arguments.of("2048", "2", "0"),
                Arguments.of("3146", "3", "74"),
                Arguments.of("13146", "12", "858"),
                Arguments.of("100146", "97", "818"),
                Arguments.of("100000000", "97656", "256"));
    }

    @Test
    void getNameShouldReturnKilobytesConverterString() {
        assertEquals("Kilobytes converter", kilobytesConverter.getName());
    }
}