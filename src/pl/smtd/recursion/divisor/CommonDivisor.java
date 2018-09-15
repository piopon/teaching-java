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
        int gcdR = greatestCommonDivisor(num1, num2);
        int gcdL = greatestCommonDivisorLoop(num1, num2);
        System.out.println("Greatest common divisor of " + num1 + " and " + num2 + " is:");
        System.out.println("  +-- " + gcdR + " [recursion]");
        System.out.println("  +-- " + gcdL + " [in a loop]");
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

    public int greatestCommonDivisorLoop(int number1, int number2) {
        int smaller = (number1 < number2) ? number1 : number2;
        int lastDivider = 1;
        int commonDivider = 0;
        while (lastDivider <= smaller) {
            if (number1%lastDivider == 0 && number2%lastDivider == 0) {
                commonDivider = lastDivider;
            }
            lastDivider++;
        }
        return commonDivider;
    }
}
