package pl.smtc.recursion.fibonacci;

import pl.smtc.menu.ConsoleExample;

import java.util.Scanner;

public class Fibonacci implements ConsoleExample {
    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter how many numbers to print: ");
        int input = in.nextInt();
        for (int i = 1; i <= input; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println(" ");
    }

    @Override
    public String getName() {
        return "Fibonacci";
    }

    public int fibonacci(int num) {
        if (num == 1 || num == 2) {
            return 1;
        }
        return fibonacci(num - 1) + fibonacci(num - 2);
    }
}
