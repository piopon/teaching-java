package pl.smtc.basics.string.checks;

import pl.smtc.menu.ConsoleExample;

public class StringEquals implements ConsoleExample {
    private final static String INPUT = "Test string";

    @Override
    public void execute() {
        System.out.println("Input string: " + INPUT);
        equalsChecks();
        contentEqualsChecks();
        compareChecks();
    }

    @Override
    public String getName() {
        return "Equality checks";
    }

    private void equalsChecks() {
        boolean isEqual = INPUT.equals("Test string");
        System.out.println("Is input equal to \'Test string\': " + isEqual);
        boolean notEqual = INPUT.equals("Test String");
        System.out.println("Is input equal to \'Test String\': " + notEqual);
        boolean caseEqual = INPUT.equalsIgnoreCase("Test String");
        System.out.println("Is input equal to \'Test String\' (ignore case): " + caseEqual);
    }

    private void contentEqualsChecks() {
        boolean contentEqual = INPUT.contentEquals("Test string");
        System.out.println("Is content equal to \'" + INPUT + "\': " + contentEqual);
        StringBuffer buffer = new StringBuffer("Test string");
        boolean bufferEqual = INPUT.contentEquals(buffer);
        System.out.println("Is buffer equal to \'" + INPUT + "\': " + contentEqual);
    }

    private void compareChecks() {
        int sameDiff = INPUT.compareTo("Test string");
        System.out.println("Comparing to \'Test string\': " + sameDiff);
        int diff = INPUT.compareTo("TEST STRING");
        System.out.println("Comparing to \'TEST STRING\': " + diff);
        int sameCase = INPUT.compareToIgnoreCase("TEST STRING");
        System.out.println("Comparing to \'TEST STRING\' (ignore case): " + sameCase);
    }
}
