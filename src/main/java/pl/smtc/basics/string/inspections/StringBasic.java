package pl.smtc.basics.string.inspections;

import pl.smtc.menu.ConsoleExample;

public class StringBasic implements ConsoleExample {
    @Override
    public void execute() {
        String inputString = "Test string";
        System.out.println("Input string: " + inputString);
        System.out.println("---------------------------------");
        int length = inputString.length();
        System.out.println("Input length: " + length);
        String internString = inputString.intern();
        System.out.println("Canonical: " + internString);
    }

    @Override
    public String getName() {
        return "Basic inspections";
    }
}
