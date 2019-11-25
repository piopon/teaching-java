package pl.smtc.basics.string.inspections;

import pl.smtc.menu.ConsoleExample;

public class StringIndex implements ConsoleExample {
    @Override
    public void execute() {
        String inputString = "Test string.";
        System.out.println("Input string: " + inputString);
        System.out.println("---------------------------------");
        int charIndex = inputString.indexOf('t');
        System.out.println("First char \'t\' index: " + charIndex);
        int charSecondIndex = inputString.indexOf('t', 4);
        System.out.println("Next char \'t\' index: " + charSecondIndex);
        int stringIndex = inputString.indexOf("st");
        System.out.println("First substring index: " + stringIndex);
        int stringSecondIndex = inputString.indexOf("st", 4);
        System.out.println("Second substring index: " + stringSecondIndex);
        int lastCharIndex = inputString.lastIndexOf('t');
        System.out.println("Last char \'t\' index: " + lastCharIndex);
        int lastCharSecondIndex = inputString.lastIndexOf('t', 4);
        System.out.println("Previous char \'t\' index: " + lastCharSecondIndex);
        int lastStringIndex = inputString.lastIndexOf("st");
        System.out.println("Last substring index: " + lastStringIndex);
        int lastStringSecondIndex = inputString.lastIndexOf("st", 4);
        System.out.println("Previous substring index: " + lastStringSecondIndex);
    }

    @Override
    public String getName() {
        return "Index searching";
    }
}
