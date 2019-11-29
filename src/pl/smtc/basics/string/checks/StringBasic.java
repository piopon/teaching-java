package pl.smtc.basics.string.checks;

import pl.smtc.menu.ConsoleExample;

public class StringBasic implements ConsoleExample {
    @Override
    public void execute() {
        String input = "Test string";
        System.out.println("Input string: " + input);
        int inputLength = input.length();
        System.out.println("Input string length" + inputLength);
        boolean isEmpty = input.isEmpty();
        System.out.println("In input string empty: " + isEmpty);
    }

    @Override
    public String getName() {
        return "Basic checks";
    }
}
