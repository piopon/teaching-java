package pl.smtc.algorithms.math.totient;

import pl.smtc.menu.ConsoleExample;
import pl.smtc.recursion.divisor.CommonDivisor;

import java.util.Scanner;

public class EulerTotient implements ConsoleExample {
    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input integer to calc Euler function: ");
        int input = in.nextInt();
        System.out.println("PHI(" + input + ") = " + phi(input));
    }

    @Override
    public String getName() {
        return "Euler totient function";
    }

    public int phi(int number) {
        int result = 1;
        for (int i = 2; i < number; i++) {
            if (new CommonDivisor().greatestCommonDivisor(i, number) == 1) {
                result++;
            }
        }
        return result;
    }
}
