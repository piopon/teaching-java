package pl.smtc.algorithms.math.digits;

import pl.smtc.menu.ConsoleExample;

import java.util.Scanner;

public class DigitsSum implements ConsoleExample {

    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input integer: ");
        long input = in.nextInt();
        System.out.println("Sum of all digits in " + input + " = " + sum(input));
    }

    @Override
    public String getName() {
        return "Sum of all digits";
    }

    public long sum(long number) {
        long sum = 0;
        while (number > 0) {
            sum = sum + number % 10;
            number = number / 10;
        }
        return sum;
    }
}
