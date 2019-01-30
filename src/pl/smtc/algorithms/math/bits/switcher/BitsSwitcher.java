package pl.smtc.algorithms.math.bits.switcher;

import pl.smtc.algorithms.math.bits.converter.FormatConverter;
import pl.smtc.menu.ConsoleExample;

import java.util.Scanner;

public class BitsSwitcher implements ConsoleExample {
    private static final String SEPARATOR = "----------------------------";

    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        FormatConverter converter = new FormatConverter();

        System.out.print("Input start number: ");
        int startNumber = in.nextInt();
        System.out.println(converter.printBin(startNumber) + " [BIN] <-> " + startNumber + " [DEC]");
        System.out.println(SEPARATOR);

        System.out.print("Which bit to turn on? ");
        int afterOn = turnOn(in.nextInt(), startNumber);
        System.out.println(converter.printBin(afterOn) + " [BIN] <-> " + afterOn + " [DEC]");
        System.out.println(SEPARATOR);

        System.out.print("Which bit to turn off? ");
        int afterOff = turnOff(in.nextInt(), afterOn);
        System.out.println(converter.printBin(afterOff) + " [BIN] <-> " + afterOff + " [DEC]");
    }

    @Override
    public String getName() {
        return "Bits switcher";
    }

    public int turnOn(int bit, int number) {
        if (bit < 0) {
            throw new IllegalArgumentException("Bit number must be >= 0.");
        }
        return (number | (1 << (bit)));
    }

    public int turnOff(int bit, int number) {
        if (bit < 0) {
            throw new IllegalArgumentException("Bit number must be >= 0.");
        }
        return (number & ~(1 << (bit)));
    }
}
