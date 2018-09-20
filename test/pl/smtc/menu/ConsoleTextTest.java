package pl.smtc.menu;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleTextTest {
    private static ConsoleText CONSOLE_TEXT;
    private static int CONSOLE_WIDTH = 30;

    @Test
    void printShouldReturnRawConsoleText() {
        CONSOLE_TEXT = new ConsoleText("  TEST text ", CONSOLE_WIDTH);
        assertEquals("  TEST text ", CONSOLE_TEXT.print());
    }

    @Test
    void trimShouldDeleteWhitespacesBeforeAndAfterText() {
        CONSOLE_TEXT = new ConsoleText("  TEST text ", CONSOLE_WIDTH);
        assertEquals("TEST text", CONSOLE_TEXT.trim().print());
    }

    @ParameterizedTest(name = "\"{0}\" repeated {1} times: \"{2}\"")
    @MethodSource("repeatTestData")
    void repeatShouldGenerateInputNTimes(String input, int repeatNo, String expected) {
        CONSOLE_TEXT = new ConsoleText(input, CONSOLE_WIDTH);
        assertEquals(expected, CONSOLE_TEXT.repeat(repeatNo).print());
    }

    private static Stream<Arguments> repeatTestData() {
        return Stream.of(
                Arguments.of("  TEST text ", -3, "  TEST text "),
                Arguments.of("  TEST text ", 0, "  TEST text "),
                Arguments.of("  TEST text ", 1, "  TEST text "),
                Arguments.of("  TEST text ", 2, "  TEST text   TEST text "),
                Arguments.of("  TEST text ", 3, "  TEST text   TEST text   TEST text "));
    }

    @ParameterizedTest(name = "\"{0}\" aligned {1}: \"{2}\"")
    @MethodSource("alignTestData")
    void alignShouldAlignTextAsInputted(String input, ConsoleAlign align, String expected) {
        CONSOLE_TEXT = new ConsoleText(input, 30);
        assertEquals(expected, CONSOLE_TEXT.align(align).print());
    }

    private static Stream<Arguments> alignTestData() {
        return Stream.of(
                Arguments.of("TEST text", ConsoleAlign.LEFT, "TEST text                     "),
                Arguments.of("TEST text", ConsoleAlign.CENTER, "          TEST text           "),
                Arguments.of("TEST text", ConsoleAlign.RIGHT, "                     TEST text"));
    }

    @Test
    void frameShouldAddCharactersAtStringBeginningAndEnd() {
        CONSOLE_TEXT = new ConsoleText("  TEST text   ", CONSOLE_WIDTH);
        assertEquals("** TEST text ** ", CONSOLE_TEXT.frame("**").print());
    }

    @Test
    void indentShouldMoveInputText3Times() {
        CONSOLE_TEXT = new ConsoleText("TEST text   ", CONSOLE_WIDTH);
        assertEquals("   TEST text", CONSOLE_TEXT.indent(3).print());
    }

    @Test
    void mixConsoleTextShouldReturnCorrectText() {
        CONSOLE_TEXT = new ConsoleText("TXT", CONSOLE_WIDTH);
        String actions = CONSOLE_TEXT.repeat(3).align(ConsoleAlign.LEFT).indent(2).frame("||").print();
        assertEquals("|| TXTTXTTXT                 || ", actions);
    }
}