package pl.smtc.basics.operators.bitwise;

import pl.smtc.menu.ConsoleExample;

import java.util.Scanner;

public class BitwiseOperators implements ConsoleExample {
    private final static int CONST_OPERAND = 0x7A;

    @Override
    public void execute() {
        System.out.print("Input number: ");
        int input = new Scanner(System.in).nextInt();
        System.out.println("Binary input:   " + intToBin(input));
        System.out.println("Binary operand: " + intToBin(CONST_OPERAND));
        int bitAnd = input & CONST_OPERAND;
        System.out.println("- bitwise and:  " + intToBin(bitAnd));
        int bitOr = input | CONST_OPERAND;
        System.out.println("- bitwise or:   " + intToBin(bitOr));
        int bitXor = input ^ CONST_OPERAND;
        System.out.println("- bitwise xor:  " + intToBin(bitXor));
        int bitNot = ~input;
        System.out.println("- bitwise not:  " + intToBin(bitNot));
    }

    @Override
    public String getName() {
        return "Bitwise operators";
    }

    private String intToBin(int input) {
        String shortBinString = Integer.toBinaryString(input);
        String longBinString = String.format("%32s", shortBinString);
        return longBinString.replaceAll(" ", "0");
    }
}
