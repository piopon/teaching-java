package pl.smtc.algorithms.math.binomial;

import pl.smtc.menu.ConsoleExample;

import java.util.Scanner;

public class BinomialCoefficient implements ConsoleExample {

    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input first integer  [n]: ");
        int n = in.nextInt();
        System.out.print("Input second integer [k]: ");
        int k = in.nextInt();

        try {
            System.out.print("C(n,k) = C(" + n + "," + k + ") = " + binomial(n,k));
            System.out.println(System.lineSeparator());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getName() {
        return "Binomial coefficient";
    }

    public int binomial(int n, int k) throws IllegalArgumentException {
        if (n < k) {
            throw new IllegalArgumentException("Bad input arguments (n < k)!");
        }
        if (k == 0 || k == n) {
            return 1;
        }
        return binomial(n - 1, k - 1) + binomial(n - 1, k);
    }
}
