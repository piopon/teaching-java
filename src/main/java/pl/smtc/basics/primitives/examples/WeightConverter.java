package pl.smtc.basics.primitives.examples;

import pl.smtc.menu.ConsoleExample;

import java.util.Locale;
import java.util.Scanner;

public class WeightConverter implements ConsoleExample {
    private final static double POUND_TO_KILOGRAM = 0.45359223;

    @Override
    public void execute() {
        System.out.print("Input weight to convert: ");
        Scanner in = new Scanner(System.in).useLocale(Locale.ENGLISH);
        double input = in.nextDouble();
        double toKilograms = input * POUND_TO_KILOGRAM;
        System.out.println(input + "lb = " + toKilograms + "kg");
        double toPounds = input * 1/POUND_TO_KILOGRAM;
        System.out.println(input + "kg = " + toPounds + "lb");
    }

    @Override
    public String getName() {
        return "Weight converter";
    }
}
