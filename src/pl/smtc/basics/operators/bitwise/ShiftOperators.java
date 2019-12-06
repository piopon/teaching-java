package pl.smtc.basics.operators.bitwise;

import pl.smtc.menu.ConsoleExample;

import java.util.Scanner;

public class ShiftOperators implements ConsoleExample {
    @Override
    public void execute() {
        System.out.print("Input number: ");
        int input = new Scanner(System.in).nextInt();
        System.out.println("Binary input:    " + intToBin(input));
        int shiftLeft = input << 10;
        System.out.println("- shift left:    " + intToBin(shiftLeft));
        int shiftRight = input >> 10;
        System.out.println("- shift right:   " + intToBin(shiftRight));
        int uShiftRight = input >>> 10;
        System.out.println("- u shift right: " + intToBin(uShiftRight));
    }

    @Override
    public String getName() {
        return "Bit shift operators";
    }

    private String intToBin(int input) {
        String shortBinString = Integer.toBinaryString(input);
        String longBinString = String.format("%32s", shortBinString);
        return longBinString.replaceAll(" ", "0");
    }
}
