package pl.smtc.algorithms.math.primes;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class PrimeNumbersTest extends BaseTestInOut {
    private PrimeNumbers primeNumbers;

    @Override
    protected void setUp() {
        primeNumbers = new PrimeNumbers();
    }

    @Test
    void executeShouldInvokePrimeNumbersExample() {
        simulateUserInput("0");
        primeNumbers.execute();
        String output = getOutput();
        assertTrue(output.contains("PRIME NUMBERS"));
        assertTrue(output.contains("1) Prime factors"));
        assertTrue(output.contains("2) Eratosthenes sieve"));
    }

    @Test
    void getNameShouldReturnPrimeNumbersString() {
        assertEquals("Prime numbers", primeNumbers.getName());
    }
}