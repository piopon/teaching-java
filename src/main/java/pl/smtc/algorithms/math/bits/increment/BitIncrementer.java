package pl.smtc.algorithms.math.bits.increment;

import pl.smtc.menu.ConsoleExample;

import java.util.Scanner;

public class BitIncrementer implements ConsoleExample {

    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input number to increment: ");
        int input = in.nextInt();
        System.out.println("Bit incremented result: " + increment(input));
    }

    @Override
    public String getName() {
        return "Bit incrementer";
    }

    public int increment(int number) {
        int m = 1;
        do {
            number ^= m;
            m <<= 1;
        } while((number & m) == 1);

        return number;
    }
}
