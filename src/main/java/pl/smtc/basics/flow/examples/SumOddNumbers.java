package pl.smtc.basics.flow.examples;

import pl.smtc.menu.ConsoleExample;

import java.util.Scanner;

public class SumOddNumbers implements ConsoleExample {
    @Override
    public void execute() {
        Scanner input = new Scanner(System.in);
        System.out.print("Range start: ");
        int rangeStart = input.nextInt();
        System.out.print("Range stop: ");
        int rangeStop = input.nextInt();
        System.out.println("---------------------");
        int oddSum = sumOdd(rangeStart, rangeStop);
        System.out.println("Sum of odd numbers: " + oddSum);
    }

    @Override
    public String getName() {
        return "Sum odd numbers";
    }

    protected int sumOdd(int start, int end) {
        if (end < start || end < 0 || start < 0 ) {
            return -1;
        }
        int sum = 0;
        for (int i = start; i <= end; i++) {
            if (isOdd(i)) {
                sum += i;
            }
        }
        return sum;
    }

    private boolean isOdd(int number) {
        if (number <= 0) {
            return false;
        }
        return number % 2 == 1;
    }

}
