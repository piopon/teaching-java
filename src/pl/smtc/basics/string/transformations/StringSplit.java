package pl.smtc.basics.string.transformations;

import pl.smtc.menu.ConsoleExample;

import java.util.Arrays;
import java.util.List;

public class StringSplit implements ConsoleExample {
    private final static String INPUT_STRING = "This is a test string";

    @Override
    public void execute() {
        System.out.println("Input string: " + INPUT_STRING);
        System.out.println("---------------------------------");
        splitExamples();
    }

    @Override
    public String getName() {
        return "String split";
    }

    private void splitExamples() {
        List<String> splitAll = Arrays.asList(INPUT_STRING.split("\\s"));
        System.out.println("All split: " + splitAll);
        List<String> splitLimit = Arrays.asList(INPUT_STRING.split("\\s", 3));
        System.out.println("Limit split: " + splitLimit);
    }
}
