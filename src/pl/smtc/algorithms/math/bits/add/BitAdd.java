package pl.smtc.algorithms.math.bits.add;

import pl.smtc.menu.ConsoleExample;

import java.util.Scanner;

public class BitAdd implements ConsoleExample {

    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input integer 1: ");
        int number1 = in.nextInt();
        System.out.print("Input integer 2: ");
        int number2 = in.nextInt();
        int result = add(number1, number2);
        System.out.print("RESULT: " + number1 + " + " + number2 + " = " + result);
        System.out.println(" ");
    }

    @Override
    public String getName() {
        return "Bit add";
    }

    public int add(int firstNumber, int secondNumber) {
        while (secondNumber != 0) {
            int carry = firstNumber & secondNumber;
            firstNumber = firstNumber ^ secondNumber;
            secondNumber = carry << 1;
        }
        return firstNumber;
    }
}
