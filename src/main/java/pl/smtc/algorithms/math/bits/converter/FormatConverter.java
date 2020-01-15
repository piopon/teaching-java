package pl.smtc.algorithms.math.bits.converter;

import pl.smtc.menu.ConsoleExample;

import java.util.Scanner;

public class FormatConverter implements ConsoleExample {

    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input number: ");
        int testNumber = in.nextInt();
        System.out.println(" * BIN: " + printBin(testNumber));
        System.out.println(" * OCT: " + printOct(testNumber));
        System.out.println(" * HEX: " + printHex(testNumber));
    }

    @Override
    public String getName() {
        return "Format converter";
    }

    public String printBin(int number) {
        String result = Integer.toBinaryString(number);
        final int groupSize = 4;
        if (result.length() % groupSize > 0) {
            int extraZeros = groupSize - (result.length() % groupSize);
            for (int i = 0; i < extraZeros; i++) {
                result = "0" + result;
            }
        }
        return result;
    }

    public String printOct(int number) {
        return Integer.toOctalString(number);
    }

    public String printHex(int number) {
        return "0x" + Integer.toHexString(number).toUpperCase();
    }
}
