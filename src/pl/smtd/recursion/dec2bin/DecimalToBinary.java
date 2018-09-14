package pl.smtd.recursion.dec2bin;

import pl.smtd.menu.ConsoleExample;

import java.util.Scanner;

public class DecimalToBinary implements ConsoleExample {
    int minInt = 1;
    int maxInt = 1000;
    private String prompt = "Enter an integer [" + minInt + " - " + maxInt + "]: ";

    @Override
    public void execute() {
        Scanner input = new Scanner(System.in);
        System.out.print(prompt);
        int decimal = input.nextInt();
        if (decimal >= minInt && decimal <= maxInt) {
            System.out.print("DECIMAL: " + decimal + " -> BINARY: ");
            System.out.print(decToBin(decimal));
            System.out.println(" ");
        } else {
            System.out.println("ERROR: Wrong number");
        }
    }

    @Override
    public String getName() {
        return "Decimal to Binary";
    }

    private static String decToBin(int dec) {
        if (dec > 0) {
            return decToBin(dec / 2) + dec%2;
        }
        return "";
    }

    private static String formatBin(String bin) {
        int bitsPerGroup = 4;

        return divideGroup(fillToGroup(bin, bitsPerGroup), bitsPerGroup);
    }

    private static String fillToGroup(String input, int groupSize) {
        String output = input;
        int groups = (input.length()/groupSize + 1);
        int zerosToAdd = groups * groupSize - input.length();
        for (int i = 0; i < zerosToAdd; i++) {
            output = "0" + output;
        }
        return output;
    }

    private static String divideGroup(String input, int groupSize) {
        StringBuilder out = new StringBuilder(input);
        int divideCount = input.length() / groupSize - 1;
        for (int i = divideCount; i > 0; i--) {
            out.insert(i * groupSize, " ");
        }
        return out.toString();
    }
}
