package pl.smtc.basics.string.transformations;

import pl.smtc.menu.ConsoleExample;

public class StringReplace implements ConsoleExample {
    @Override
    public void execute() {
        String inputString = "This is a test string";
        System.out.println("Input string: " + inputString);
        System.out.println("---------------------------------");
        String charReplace = inputString.replace(' ', '_');
        System.out.println("Char replace: " + charReplace);
        String stringReplace = inputString.replace("test", "final");
        System.out.println("String replace: " + stringReplace);
        String firstReplace = inputString.replaceFirst("\\s", "");
        System.out.println("First replace: " + firstReplace);
        String allReplace = inputString.replaceAll("\\s", "");
        System.out.println("All replace: " + allReplace);
    }

    @Override
    public String getName() {
        return "Replacing parts";
    }
}
