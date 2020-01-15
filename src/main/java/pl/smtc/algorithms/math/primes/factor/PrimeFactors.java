package pl.smtc.algorithms.math.primes.factor;

import pl.smtc.menu.ConsoleExample;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeFactors implements ConsoleExample {

    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input integer to find prime factors: ");
        System.out.println("Prime factors: " + getFactors(in.nextInt()));
    }

    @Override
    public String getName() {
        return "Prime factors";
    }

    public List<Integer> getFactors(Integer number) {
        List<Integer> factors = new ArrayList<>();

        int oddComponent = findSmallestOddComponent(number);
        if (oddComponent != number) {
            factors.add(2);
        }
        factors.addAll(getOddFactors(oddComponent));
        if (factors.isEmpty()) {
            factors.add(number);
        }
        return factors;
    }

    private Integer findSmallestOddComponent(Integer initial) {
        int result = initial;
        if (initial % 2 == 0) {
            while (result % 2 == 0) {
                result /= 2;
            }
        }
        return result;
    }

    private List<Integer> getOddFactors(Integer number) {
        List<Integer> oddFactors = new ArrayList<>();
        for (int i = 3; i <= number; i += 2) {
            if (number % i == 0) {
                while (number % i == 0) {
                    number = number / i;
                }
                oddFactors.add(i);
            }
        }
        return oddFactors;
    }
}
