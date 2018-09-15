package pl.smtd.recursion.factorial;

import pl.smtd.menu.ConsoleExample;

import java.util.Scanner;
import java.util.function.Function;

public class Factorial implements ConsoleExample {
    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number to calculate the factorial: ");
        int input = in.nextInt();
        System.out.println("RESULT (recursive): " + comparisonOutput(this::factorial, input));
        System.out.println("RESULT (in a loop): " + comparisonOutput(this::factorialLoop, input));
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

    public int factorialLoop(int num) {
        int result = 1;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }

    private String comparisonOutput(Function<Integer, Integer> function, int number) {
        long timeStart = System.nanoTime();
        int result = function.apply(number);
        long timeStop = System.nanoTime();

        return number + "! = "  + result + " [ time: " + (timeStop - timeStart) + "ns ]";
    }
}
