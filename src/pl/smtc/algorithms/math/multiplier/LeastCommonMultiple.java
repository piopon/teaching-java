package pl.smtc.algorithms.math.multiplier;

import pl.smtc.menu.ConsoleExample;
import pl.smtc.recursion.divisor.CommonDivisor;

import java.util.Scanner;

public class LeastCommonMultiple implements ConsoleExample {

    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input first integer: ");
        int number1 = in.nextInt();
        System.out.print("Input second integer: ");
        int number2 = in.nextInt();
        int lcm = get(number1, number2);
        System.out.println(getName() + " of " + number1 + " and " + number2 + " = " + lcm);
    }

    @Override
    public String getName() {
        return "Least common multiplier";
    }

    public int get(int firstNumber, int secondNumber) {
        int gcd = new CommonDivisor().greatestCommonDivisor(firstNumber, secondNumber);

        return (firstNumber * secondNumber) / gcd;
    }
}
