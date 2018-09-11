package pl.smtd.recursion;

import pl.smtd.menu.ConsoleExample;

import java.util.Scanner;
import java.util.function.BiFunction;

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

    private boolean doCompare() {
        in.nextLine();
        System.out.print("Compare with regular Math.pow method? [Y/N] ");
        String compareReq = in.nextLine();

        return compareReq.toUpperCase().equals("Y");
    }

    private void comparePowerMethods(double num, int exp) {
        Timer mathPower = new Timer(Math::pow);
        mathPower.execute(num, exp);
        mathPower.summary("Math::pow");

        Timer quickPower = new Timer(this::power);
        quickPower.execute(num, exp);
        quickPower.summary("this::pow");
    }

    private class Timer {
        private BiFunction<Double, Integer, Double> function;
        private long time;
        private double result;
        private double doubleArg;
        private int intArg;

        public Timer(BiFunction<Double, Integer, Double> function) {
            this.function = function;
        }

        public void execute(double doubleNum, int intNum) {
            long timeStart = System.nanoTime();
            result = function.apply(doubleNum, intNum);
            long timeStop = System.nanoTime();
            //store data
            doubleArg = doubleNum;
            intArg = intNum;
            time = timeStop - timeStart;
        }

        public void summary(String title) {
            String resultMessage = doubleArg + " ^ " + intArg + " = " + result;
            String timeMessage = "time = " + time + "ns";
            System.out.println(title + ": " + resultMessage + " [ " + timeMessage + " ]");
        }
    }
}
