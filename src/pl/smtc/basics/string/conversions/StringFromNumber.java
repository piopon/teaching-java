package pl.smtc.basics.string.conversions;

import pl.smtc.menu.ConsoleExample;

public class StringFromNumber implements ConsoleExample {
    @Override
    public void execute() {
        String doubleString = String.valueOf(3.71d);
        System.out.println("Double to String: " + doubleString);
        String floatString = String.valueOf(10.23f);
        System.out.println("Float to String: " + floatString);
        String intString = String.valueOf(987);
        System.out.println("Integer to String: " + intString);
        String longString = String.valueOf(100L);
        System.out.println("Long to String: " + longString);
    }

    @Override
    public String getName() {
        return "Number to string";
    }
}
