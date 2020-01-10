package pl.smtc.basics.primitives.examples;

import pl.smtc.menu.ConsoleExample;

public class DefaultValues implements ConsoleExample {
    private byte defaultByte;
    private short defaultShort;
    private int defaultInt;
    private long defaultLong;
    private double defaultDouble;
    private float defaultFloat;
    private boolean defaultBool;
    private char defaultChar;

    @Override
    public void execute() {
        System.out.println("Default values:");
        System.out.println(" - byte = " + defaultByte);
        System.out.println(" - short = " + defaultShort);
        System.out.println(" - int = " + defaultInt);
        System.out.println(" - long = " + defaultLong);
        System.out.println(" - double = " + defaultDouble);
        System.out.println(" - float = " + defaultFloat);
        System.out.println(" - boolean = " + defaultBool);
        System.out.println(" - char = " + defaultChar);
    }

    @Override
    public String getName() {
        return "Default values";
    }
}
