package pl.smtd.recursion.power;

import pl.smtd.menu.ConsoleExample;

import java.util.Scanner;

public class QuickPower implements ConsoleExample {
    Scanner in = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.print("Enter number base: ");
        double number = in.nextDouble();
        System.out.print("Enter exponent: ");
        int exp = in.nextInt();
        if (doCompare()) {
            comparePowerMethods(number, exp);
        } else {
            System.out.println("RESULT: " + number + " ^ " + exp + " = " + power(number, exp));
        }
    }

    @Override
    public String getName() {
        return "Raise number to power";
    }

    public double power(double base, int exponent) {
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

    private boolean doCompare() {
        in.nextLine();
        System.out.print("Compare with regular Math.pow method? [Y/N] ");
        String compareReq = in.nextLine();

        return compareReq.toUpperCase().equals("Y");
    }

    private void comparePowerMethods(double num, int exp) {
        TestTimer mathPower = new TestTimer(Math::pow);
        mathPower.execute(num, exp);
        System.out.println(mathPower.getSummary("Math::pow"));

        TestTimer quickPower = new TestTimer(this::power);
        quickPower.execute(num, exp);
        System.out.println(quickPower.getSummary("this::pow"));
    }
}
