package pl.smtc.basics.flow.examples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.smtc.base.BaseTestInOut;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeNumberTest extends BaseTestInOut {
    private PalindromeNumber palindromeNumber;

    @Override
    protected void setUp() {
        palindromeNumber = new PalindromeNumber();
    }

    @Test
    void executeShouldInvokePalindromeNumberExample() {
        simulateCommaInput("121");
        palindromeNumber.execute();
        String output = getOutput();
        assertTrue(output.contains("Number 121 IS a palindrome number."));
    }

    @Test
    void getNameShouldReturnPalindromeNumberString() {
        assertEquals("Palindrome number", palindromeNumber.getName());
    }

    @ParameterizedTest(name = "Is {0} a palindrome number? {1}")
    @MethodSource("isPalindromeTestData")
    void isPalindromeShouldReturnCorrectResult(int number, boolean expected) {
        assertEquals(expected, palindromeNumber.isPalindrome(number));
    }

    private static Stream<Arguments> isPalindromeTestData() {
        return Stream.of(
                Arguments.of(-1221, true),
                Arguments.of(-135, false),
                Arguments.of(-1, true),
                Arguments.of(0, true),
                Arguments.of(1, true),
                Arguments.of(7, true),
                Arguments.of(11, true),
                Arguments.of(45, false),
                Arguments.of(292, true),
                Arguments.of(711, false),
                Arguments.of(1111, true),
                Arguments.of(2331, false));
    }
}