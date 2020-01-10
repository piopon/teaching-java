package pl.smtc.recursion.fibonacci;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.smtc.base.BaseTestInOut;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest extends BaseTestInOut {
    private Fibonacci fibonacci;

    @Override
    protected void setUp() {
        fibonacci = new Fibonacci();
    }

    @Test
    void executeShouldOutputCorrectFibonacciNumbers() {
        simulateUserInput("5");
        fibonacci.execute();
        String output = getOutput();
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
}