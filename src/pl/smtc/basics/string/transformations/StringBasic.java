package pl.smtc.basics.string.transformations;

import pl.smtc.menu.ConsoleExample;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringBasic implements ConsoleExample {
    private final static String INPUT_STRING = "  This is a test string";
    private final static String SEPARATOR = "---------------------------------";

    @Override
    public void execute() {
        System.out.println("Input string: " + INPUT_STRING);
        baseExamples();
        joinExamples();
    }

    @Override
    public String getName() {
        return "String basic transformations";
    }

    private void baseExamples() {
        System.out.println(SEPARATOR);
        String added = INPUT_STRING + " with const addition.";
        System.out.println("Added string: " + added);
        String lower = INPUT_STRING.toLowerCase();
        System.out.println("Lower string: " + lower);
        String upper = INPUT_STRING.toUpperCase();
        System.out.println("Upped string: " + upper);
        String trimmed = INPUT_STRING.trim();
        System.out.println("Trimmed string: " + trimmed);
    }

    private void joinExamples() {
        System.out.println(SEPARATOR);
        String constJoined = String.join("+", "my", "test", "str");
        System.out.println("Const joined string: " + constJoined);
        Set<String> strings = new HashSet<>(Arrays.asList("strings","in","set"));
        String setJoined = String.join("=", strings);
        System.out.println("Set joined string: " + setJoined);
    }
}
