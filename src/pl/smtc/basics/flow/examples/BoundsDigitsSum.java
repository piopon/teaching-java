package pl.smtc.basics.flow.examples;

import pl.smtc.menu.ConsoleExample;

import java.util.Scanner;

public class BoundsDigitsSum implements ConsoleExample {
    @Override
    public void execute() {
        System.out.print("Input number (positive): ");
        int number = new Scanner(System.in).nextInt();
        System.out.println("First and last digits sum = " + sumFirstAndLastDigit(number));
    }

    @Override
    public String getName() {
        return "Bound digits sum";
    }

    protected int sumFirstAndLastDigit(int number) {
        if (number < 0) {
            return -1;
        } else if (number < 10) {
            return number * 2;
        }

        int sum = 0;
        while (number > 0) {
            if (sum == 0) {
                sum += number % 10;
            }
            number /= 10;
            if (number < 10) {
                sum += number;
                break;
            }
        }
        return sum;
    }
}
