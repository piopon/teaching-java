package pl.smtd.recursion;

import pl.smtd.menu.ConsoleExample;

import java.util.Scanner;

public class QuickPower implements ConsoleExample {
    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number base: ");
        double number = in.nextDouble();
        System.out.print("Enter exponent: ");
        int exp = in.nextInt();
        System.out.println("RESULT: " + number + " ^ " + exp + " = " + power(number, exp));
    }

    @Override
    public String getName() {
        return "Raise number to power";
    }

    private double power(double base, int exponent) {
        double y;
        if (exponent == 0) {
            return 1.0;
        }
        y = power(base, exponent / 2);
        y = y * y;
        if (exponent % 2 == 0) {
            return y;
        }
        return base * y;
    }
}
