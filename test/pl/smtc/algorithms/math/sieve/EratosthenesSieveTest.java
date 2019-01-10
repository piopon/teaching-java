package pl.smtc.algorithms.math.sieve;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.smtc.base.BaseTestInOut;
import pl.smtc.base.BaseTestOut;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class EratosthenesSieveTest extends BaseTestInOut {
    private EratosthenesSieve eratosthenesSieve;

    @Override
    protected void setUp() {
        eratosthenesSieve = new EratosthenesSieve();
    }

    @Test
    void executeShouldInvokeEratosthenesSieveExample() {
        simulateUserInput("50" + System.lineSeparator());
        eratosthenesSieve.execute();
        String output = getOutput();
        assertTrue(output.contains("Input max num to search for primes:"));
        assertTrue(output.contains("[0, 1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47]"));
    }

    @Test
    void getNameShouldReturnEratosthenesSieveString() {
        assertEquals("Eratosthenes sieve", eratosthenesSieve.getName());
    }

    @ParameterizedTest(name = "All primes to {1} = {0}")
    @MethodSource("sieveTestData")
    void getPrimesShouldReturnPrimesTable(List<Integer> primes, int endSearch) {
        assertEquals(primes, eratosthenesSieve.getPrimes(endSearch));
    }

    private static Stream<Arguments> sieveTestData() {
        return Stream.of(
                Arguments.of(Arrays.asList(0), 0),
                Arguments.of(Arrays.asList(0, 1), 1),
                Arguments.of(Arrays.asList(0, 1, 2), 2),
                Arguments.of(Arrays.asList(0, 1, 2, 3), 4),
                Arguments.of(Arrays.asList(0, 1, 2, 3, 5), 6),
                Arguments.of(Arrays.asList(0, 1, 2, 3, 5, 7), 8),
                Arguments.of(Arrays.asList(0, 1, 2, 3, 5, 7), 10),
                Arguments.of(Arrays.asList(0, 1, 2, 3, 5, 7, 11), 12),
                Arguments.of(Arrays.asList(0, 1, 2, 3, 5, 7, 11, 13), 14),
                Arguments.of(Arrays.asList(0, 1, 2, 3, 5, 7, 11, 13), 16),
                Arguments.of(Arrays.asList(0, 1, 2, 3, 5, 7, 11, 13, 17), 18),
                Arguments.of(Arrays.asList(0, 1, 2, 3, 5, 7, 11, 13, 17, 19), 20),
                Arguments.of(Arrays.asList(0, 1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29), 30),
                Arguments.of(Arrays.asList(0, 1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37), 40));
    }
}