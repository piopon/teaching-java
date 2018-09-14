package pl.smtd.recursion.divisor;

import pl.smtd.menu.ConsoleExample;

import java.util.Scanner;

public class CommonDivisor implements ConsoleExample {
    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter two number to find greatest common divisor.");
        System.out.print("  +-- number 1: ");
        int num1 = in.nextInt();
        System.out.print("  +-- number 2: ");
        int num2 = in.nextInt();
        int gcd = greatestCommonDivisor(num1, num2);
        System.out.println("Greatest common divisor of " + num1 + " and " + num2 + " is: " + gcd);
        System.out.println(" ");
    }

    @Override
    public String getName() {
        return "Greatest common divisor";
    }

    public int greatestCommonDivisor(int number1, int number2) {
        if (number1 < number2) {
            int temp = number1;
            number1 = number2;
            number2 = temp;
        }
        if (number2 == 0) {
            return number1;
        }
        return greatestCommonDivisor(number2, number1%number2);
    }
}
