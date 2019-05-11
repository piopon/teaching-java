package pl.smtc.patterns.structural.composite.utilities;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @ParameterizedTest(name = "{0} repeated {1} times: {2}")
    @MethodSource("repeatTestData")
    void repeatShouldReturnCorrectString(String str, int times, String expected) {
        assertEquals(expected, StringUtils.repeat(str, times));
    }

    private static Stream<Arguments> repeatTestData() {
        return Stream.of(
                Arguments.of("!", 1, "!"),
                Arguments.of("@", 2, "@@"),
                Arguments.of("#", 3, "###"),
                Arguments.of("$", 4, "$$$$"),
                Arguments.of("%", 5, "%%%%%"),
                Arguments.of("^", 6, "^^^^^^"),
                Arguments.of("&", 7, "&&&&&&&"),
                Arguments.of("*", 8, "********"),
                Arguments.of("(", 9, "((((((((("),
                Arguments.of(")", 10, "))))))))))"));
    }
}