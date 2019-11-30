package pl.smtc.basics.string.checks;

import pl.smtc.menu.ConsoleExample;

public class StringEquals implements ConsoleExample {
    @Override
    public void execute() {
        String input = "Test string";
        System.out.println("Input string: " + input);
        boolean isEqual = input.equals("Test string");
        System.out.println("Is input equal to \'Test string\': " + isEqual);
        boolean notEqual = input.equals("Test String");
        System.out.println("Is input equal to \'Test String\': " + notEqual);
        boolean caseEqual = input.equalsIgnoreCase("Test String");
        System.out.println("Is input equal to \'Test String\' (ignore case): " + caseEqual);
    }

    @Override
    public String getName() {
        return "Equality checks";
    }
}
