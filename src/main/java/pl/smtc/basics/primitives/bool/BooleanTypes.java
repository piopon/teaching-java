package pl.smtc.basics.primitives.bool;

import pl.smtc.menu.ConsoleExample;

public class BooleanTypes implements ConsoleExample {
    @Override
    public void execute() {
        boolean trueValue = true;
        boolean falseValue = false;
        System.out.println("Boolean values:");
        System.out.println(" - trueValue = " + trueValue);
        System.out.println(" - falseValue = " + falseValue);

        printSummary();
    }

    @Override
    public String getName() {
        return "Boolean types";
    }

    private void printSummary() {
        System.out.println("-------------------------------------------");
        System.out.println("Boolean types summary");
        System.out.println(" - bool: represents one bit but its \"size\" isn't precisely defined");
    }
}
