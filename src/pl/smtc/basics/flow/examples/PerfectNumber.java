package pl.smtc.basics.flow.examples;

import pl.smtc.menu.ConsoleExample;

import java.util.Scanner;

public class PerfectNumber implements ConsoleExample {
    @Override
    public void execute() {
        System.out.print("Input number: ");
        int number = new Scanner(System.in).nextInt();
        String status = isPerfectNumber(number) ? "IS" : "IS NOT";
        System.out.println("Number " + number + " " + status + " a perfect number");
    }

    @Override
    public String getName() {
        return "Perfect number";
    }

    protected boolean isPerfectNumber(int number) {
        if(number < 1) {
            return false;
        }
        int sumFactors = 0, lastFactor = 1;
        while (lastFactor < number) {
            if (number % lastFactor == 0) {
                sumFactors += lastFactor;
            }
            lastFactor++;
        }
        return sumFactors == number;
    }
}
