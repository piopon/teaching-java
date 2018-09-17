package pl.smtc.recursion.factorial;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {
    private Factorial factorial;
    private static final ByteArrayOutputStream OUTPUT_STREAM = new ByteArrayOutputStream();

    @BeforeEach
    void setup() {
        factorial = new Factorial();
        System.setOut(new PrintStream(OUTPUT_STREAM));
    }

    @AfterEach
    void teardown() {
        System.setIn(System.in);
        System.setOut(System.out);
    }

    @Test
    void executeShouldOutputCorrectFactorialOfTwoInputtedNumbers() {
        simulateUserInput("5");
        factorial.execute();
        String output = OUTPUT_STREAM.toString();
        assertTrue(output.contains("RESULT (recursive): 5! = 120"));
        assertTrue(output.contains("RESULT (in a loop): 5! = 120"));
    }

    @Test
    void getNameShouldReturnFactorial() {
        assertEquals("Factorial", factorial.getName());
    }

    @ParameterizedTest(name = "{0}! = {1}")
    @MethodSource("factorialTestData")
    void factorialReturnsCorrectValue(int number, int result) {
        assertEquals(result, factorial.factorial(number));
    }

    @ParameterizedTest(name = "{0}! = {1}")
    @MethodSource("factorialTestData")
    void factorialLoopReturnsCorrectValue(int number, int result) {
        assertEquals(result, factorial.factorialLoop(number));
    }

    private static Stream<Arguments> factorialTestData() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, 2),
                Arguments.of(3, 6),
                Arguments.of(4, 24),
                Arguments.of(5, 120),
                Arguments.of(6, 720),
                Arguments.of(7, 5040),
                Arguments.of(8, 40320),
                Arguments.of(9, 362880),
                Arguments.of(10, 3628800));
    }

    private void simulateUserInput(String simInput) {
        System.setIn(new ByteArrayInputStream(simInput.getBytes()));
    }
}