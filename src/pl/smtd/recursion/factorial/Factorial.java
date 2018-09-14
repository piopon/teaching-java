package pl.smtd.recursion.factorial;

import pl.smtd.menu.ConsoleExample;

import java.util.Scanner;

public class Factorial implements ConsoleExample {
    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number to calculate the factorial: ");
        int input = in.nextInt();
        System.out.print("RESULT: " + input + "! = "  + factorial(input));
        System.out.println(" ");
    }

    @Override
    public String getName() {
        return "Factorial";
    }

    public int factorial(int num) {
        if (num == 1) {
            return 1;
        }
        return num * factorial(num - 1);
    }
}
