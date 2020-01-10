package pl.smtc.basics.string.conversions;

import pl.smtc.menu.ConsoleExample;

public class StringFromBool implements ConsoleExample {
    @Override
    public void execute() {
        String stringTrue = String.valueOf(true);
        System.out.println("Boolean \'true\' to String: " + stringTrue);
        String stringFalse = String.valueOf(false);
        System.out.println("Boolean \'false\' to String: " + stringFalse);
    }

    @Override
    public String getName() {
        return "Bool to string";
    }
}
