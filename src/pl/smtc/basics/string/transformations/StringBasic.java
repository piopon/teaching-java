package pl.smtc.basics.string.transformations;

import pl.smtc.menu.ConsoleExample;

public class StringBasic implements ConsoleExample {
    private final static String INPUT_STRING = "  This is a test string";

    @Override
    public void execute() {
        System.out.println("Input string: " + INPUT_STRING);
        baseExamples();
        String joined = String.join("+", "my", "test", "str");
        System.out.println("Joined string: " + joined);
    }

    @Override
    public String getName() {
        return "String basic transformations";
    }

    private void baseExamples() {
        String added = INPUT_STRING + " with const addition.";
        System.out.println("Added string: " + added);
        String lower = INPUT_STRING.toLowerCase();
        System.out.println("Lower string: " + lower);
        String upper = INPUT_STRING.toUpperCase();
        System.out.println("Upped string: " + upper);
        String trimmed = INPUT_STRING.trim();
        System.out.println("Trimmed string: " + trimmed);
    }
}
