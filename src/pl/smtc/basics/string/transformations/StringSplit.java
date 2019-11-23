package pl.smtc.basics.string.transformations;

import pl.smtc.menu.ConsoleExample;

import java.util.Arrays;
import java.util.List;

public class StringSplit implements ConsoleExample {
    private final static String INPUT_STRING = "This is a test string";
    private final static String SEPARATOR = "---------------------------------";

    @Override
    public void execute() {
        System.out.println("Input string: " + INPUT_STRING);
        splitExamples();
        substringExamples();
        subsequenceExamples();
    }

    @Override
    public String getName() {
        return "String split";
    }

    private void splitExamples() {
        System.out.println(SEPARATOR);
        List<String> splitAll = Arrays.asList(INPUT_STRING.split("\\s"));
        System.out.println("All split: " + splitAll);
        List<String> splitLimit = Arrays.asList(INPUT_STRING.split("\\s", 3));
        System.out.println("Limit split: " + splitLimit);
    }

    private void substringExamples() {
        final int lowBound = 6, topBound = 13, offBound = 100;
        try {
            System.out.println(SEPARATOR);
            String substringOneBound = INPUT_STRING.substring(lowBound);
            System.out.println("Substring one bound: " + substringOneBound);
            String substringTwoBound = INPUT_STRING.substring(lowBound, topBound);
            System.out.println("Substring two bounds: " + substringTwoBound);
            String substringOffBound = INPUT_STRING.substring(lowBound, offBound);
            System.out.println("Substring off bounds: " + substringOffBound);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Substring error: " + e.getMessage());
        }
    }

    private void subsequenceExamples() {
        final int lowBound = 6, topBound = 13, offBound = 100;
        try {
            System.out.println(SEPARATOR);
            CharSequence substringTwoBound = INPUT_STRING.subSequence(lowBound, topBound);
            System.out.println("Subsequence two bounds: " + substringTwoBound);
            CharSequence substringOffBound = INPUT_STRING.subSequence(lowBound, offBound);
            System.out.println("Subsequence off bounds: " + substringOffBound);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Subsequence error: " + e.getMessage());
        }
    }
}
