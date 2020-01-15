package pl.smtc.basics.primitives.examples;

import pl.smtc.menu.ConsoleExample;

import java.util.Locale;
import java.util.Scanner;

public class KilobytesConverter implements ConsoleExample {
    @Override
    public void execute() {
        System.out.print("Input KB size: ");
        Scanner in = new Scanner(System.in).useLocale(Locale.ENGLISH);
        long kiloBytes = Integer.toUnsignedLong(in.nextInt());
        long megaBytes = kiloBytes / 1024;
        long restBytes = kiloBytes % 1024;
        System.out.println(kiloBytes + " KB = " + megaBytes + " MB and " + restBytes + " KB");
    }

    @Override
    public String getName() {
        return "Kilobytes converter";
    }
}
