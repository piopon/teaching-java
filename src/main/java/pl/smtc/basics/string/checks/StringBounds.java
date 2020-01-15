package pl.smtc.basics.string.checks;

import pl.smtc.menu.ConsoleExample;

public class StringBounds implements ConsoleExample {
    private static final String INPUT_STRING = "My input string";

    @Override
    public void execute() {
        System.out.println("Input string: " + INPUT_STRING);
        startExamples();
        endExamples();
    }

    @Override
    public String getName() {
        return "Boundaries checks";
    }

    private void startExamples() {
        String myStr = "My", inStr = "in";
        boolean trueStart = INPUT_STRING.startsWith(myStr);
        System.out.println("Input starts with \'" + myStr + "\': " + trueStart);
        boolean falseStart = INPUT_STRING.startsWith(inStr);
        System.out.println("Input starts with \'" + inStr + "\': " + falseStart);
        boolean trueOffsetStart = INPUT_STRING.startsWith(inStr, 3);
        System.out.println("Offset starts with \'" + inStr + "\': " + trueOffsetStart);
    }

    private void endExamples() {
        String ringStr = "ring", boringStr = "boring";
        boolean trueEnd = INPUT_STRING.endsWith(ringStr);
        System.out.println("Input ends with \'" + ringStr + "\': " + trueEnd);
        boolean falseEnd = INPUT_STRING.endsWith(boringStr);
        System.out.println("Input ends with \'" + boringStr + "\': " + falseEnd);
    }
}
