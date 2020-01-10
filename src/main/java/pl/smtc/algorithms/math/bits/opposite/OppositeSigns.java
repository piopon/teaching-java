package pl.smtc.algorithms.math.bits.opposite;

import pl.smtc.menu.ConsoleExample;

import java.util.Scanner;

public class OppositeSigns implements ConsoleExample {
    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input first number: ");
        int number1 = in.nextInt();
        System.out.print("Input second number: ");
        int number2 = in.nextInt();
        String checkResult = (hasOppositeSigns(number1,number2) ? "" : "NOT ") + "OPPOSITE";
        System.out.println("Numbers " + number1 + " and " + number2 + ": " + checkResult);
    }

    @Override
    public String getName() {
        return "Check opposite signs";
    }

    public boolean hasOppositeSigns(int num1, int num2) {
        return (num1 ^ num2) < 0;
    }
}
