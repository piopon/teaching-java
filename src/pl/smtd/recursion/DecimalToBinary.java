package pl.smtd.recursion;

import pl.smtd.menu.ConsoleExample;

import java.util.Scanner;

public class DecimalToBinary implements ConsoleExample {
    private String prompt = "Enter an integer [1 - 1000 | Q to exit]: ";

    @Override
    public void execute() {
        Scanner input = new Scanner(System.in);
        System.out.print(prompt);
        while(input.hasNextInt()) {
            int decimal = input.nextInt();
            if (decimal >= 1 && decimal <= 1000) {
                System.out.print("DECIMAL: "+ decimal +" -> BINARY: ");
                decToBin(decimal);
                System.out.println(" ");
            } else {
                System.out.println("ERROR: Wrong number");
            }
            System.out.print(prompt);
        }
    }

    @Override
    public String getName() {
        return "Decimal to Binary";
    }

    private static void decToBin(int dec) {
        if (dec > 0) {
            decToBin(dec/2);
            System.out.printf("%d", dec%2);
        }
    }
}
