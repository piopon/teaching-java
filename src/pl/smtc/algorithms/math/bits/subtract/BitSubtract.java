package pl.smtc.algorithms.math.bits.subtract;

import pl.smtc.menu.ConsoleExample;

import java.util.Scanner;

public class BitSubtract implements ConsoleExample {

    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input positive integer 1: ");
        int number1 = in.nextInt();
        System.out.print("Input positive integer 2: ");
        int number2 = in.nextInt();
        try {
            int result = subtract(number1, number2);
            System.out.print("RESULT: " + number1 + " - " + number2 + " = " + result);
            System.out.println(" ");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getName() {
        return "Bit subtract";
    }

    public int subtract(int firstNumber, int secondNumber) throws IllegalArgumentException {
        if (firstNumber < 0 || secondNumber < 0) {
            throw new IllegalArgumentException("ERROR: Integer(s) cannot be negative.");
        }
        while (secondNumber != 0) {
            int borrow = (~firstNumber) & secondNumber;
            firstNumber = firstNumber ^ secondNumber;
            secondNumber = borrow << 1;
        }
        return firstNumber;
    }
}
