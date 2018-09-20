package pl.smtc.recursion.fibonacci;

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

class FibonacciTest {
    private Fibonacci fibonacci;
    private static final ByteArrayOutputStream OUTPUT_STREAM = new ByteArrayOutputStream();

    @BeforeEach
    void setup() {
        fibonacci = new Fibonacci();
        System.setOut(new PrintStream(OUTPUT_STREAM));
    }

    @AfterEach
    void teardown() {
        System.setIn(System.in);
        System.setOut(System.out);
        OUTPUT_STREAM.reset();
    }

    @Test
    void executeShouldOutputCorrectFibonacciNumbers() {
        simulateUserInput("5");
        fibonacci.execute();
        String output = OUTPUT_STREAM.toString();
        assertTrue(output.contains("1 1 2 3 5"));
    }

    @Test
    void getNameShouldReturnFibonacci() {
        assertEquals("Fibonacci", fibonacci.getName());
    }

    @ParameterizedTest(name = "fibonacci({0}) = {1}")
    @MethodSource("fibonacciTestData")
    void fibonacciReturnsCorrectValue(int number, int result) {
        assertEquals(result, fibonacci.fibonacci(number));
    }

    private static Stream<Arguments> fibonacciTestData() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, 1),
                Arguments.of(4, 3),
                Arguments.of(6, 8),
                Arguments.of(10, 55),
                Arguments.of(12, 144),
                Arguments.of(15, 610),
                Arguments.of(20, 6765));
    }

    private void simulateUserInput(String simInput) {
        System.setIn(new ByteArrayInputStream(simInput.getBytes()));
    }
}