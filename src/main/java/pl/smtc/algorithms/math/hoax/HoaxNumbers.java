package pl.smtc.algorithms.math.hoax;

import pl.smtc.algorithms.math.digits.DigitsSum;
import pl.smtc.algorithms.math.primes.factor.PrimeFactors;
import pl.smtc.menu.ConsoleExample;

import java.util.List;
import java.util.Scanner;

public class HoaxNumbers implements ConsoleExample {

    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input integer: ");
        int input = in.nextInt();
        String status = "is" + (isHoax(input) ? " " : " NOT ") + "a hoax number.";
        System.out.println("Number " + input + " " + status);
    }

    @Override
    public String getName() {
        return "Hoax numbers";
    }

    public boolean isHoax(int number) {
        List<Integer> primeFactors = new PrimeFactors().getFactors(number);
        if (primeFactors.get(0) == number) {
            return false;
        }
        DigitsSum digitsSum = new DigitsSum();
        int allFactorsDigitSum = 0;
        for (int i = 0; i < primeFactors.size(); i++) {
            allFactorsDigitSum += digitsSum.sum(primeFactors.get(i));
        }
        return allFactorsDigitSum == digitsSum.sum(number);
    }
}
