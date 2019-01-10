package pl.smtc.algorithms.math.sieve;

import pl.smtc.menu.ConsoleExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EratosthenesSieve implements ConsoleExample {

    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input max num to search for primes: ");
        System.out.println(getPrimes(in.nextInt()));
    }

    @Override
    public String getName() {
        return "Eratosthenes sieve";
    }

    public List<Integer> getPrimes(int endSearch) {
        boolean[] isPrime = new boolean[endSearch + 1];
        Arrays.fill(isPrime, true);
        for (int p = 2; p * p <= endSearch; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= endSearch; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        return convert(isPrime);
    }

    private List<Integer> convert(boolean[] isPrimeTable) {
        final List<Integer> primes = new ArrayList<>();
        for(int i = 0; i < isPrimeTable.length; i++) {
            if (isPrimeTable[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
}
