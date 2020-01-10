package pl.smtc.basics.string.inspections;

import pl.smtc.menu.ConsoleExample;

public class StringIndex implements ConsoleExample {
    private final static String INPUT_STRING = "Test string.";

    @Override
    public void execute() {
        System.out.println("Input string: " + INPUT_STRING);
        System.out.println("---------------------------------");
        indexString();
        lastIndexString();
    }

    @Override
    public String getName() {
        return "Index searching";
    }

    private void indexString() {
        int charIndex = INPUT_STRING.indexOf('t');
        System.out.println("First char \'t\' index: " + charIndex);
        int charSecondIndex = INPUT_STRING.indexOf('t', 4);
        System.out.println("Next char \'t\' index: " + charSecondIndex);
        int stringIndex = INPUT_STRING.indexOf("st");
        System.out.println("First substring index: " + stringIndex);
        int stringSecondIndex = INPUT_STRING.indexOf("st", 4);
        System.out.println("Second substring index: " + stringSecondIndex);
    }

    private void lastIndexString() {
        int lastCharIndex = INPUT_STRING.lastIndexOf('t');
        System.out.println("Last char \'t\' index: " + lastCharIndex);
        int lastCharSecondIndex = INPUT_STRING.lastIndexOf('t', 4);
        System.out.println("Previous char \'t\' index: " + lastCharSecondIndex);
        int lastStringIndex = INPUT_STRING.lastIndexOf("st");
        System.out.println("Last substring index: " + lastStringIndex);
        int lastStringSecondIndex = INPUT_STRING.lastIndexOf("st", 4);
        System.out.println("Previous substring index: " + lastStringSecondIndex);
    }
}
