package pl.smtc.algorithms.math.primes;

import pl.smtc.algorithms.math.primes.sieve.EratosthenesSieve;
import pl.smtc.menu.ConsoleExample;
import pl.smtc.menu.ConsoleMenu;

import java.util.HashMap;
import java.util.Map;

public class PrimeNumbers implements ConsoleExample {
    private Map<Integer, ConsoleExample> primeNumbersAlgorithms = new HashMap<>();
    private int menuWidth = 35;

    @Override
    public void execute() {
        addExamples(new EratosthenesSieve());

        ConsoleMenu primeNumbersMenu = new ConsoleMenu(getName(), menuWidth, primeNumbersAlgorithms);
        primeNumbersMenu.show();
    }

    @Override
    public String getName() {
        return "Prime numbers";
    }

    private void addExamples(ConsoleExample... examples) {
        for (int i = 0; i < examples.length; i++) {
            primeNumbersAlgorithms.put(i, examples[i]);
        }
    }
}
