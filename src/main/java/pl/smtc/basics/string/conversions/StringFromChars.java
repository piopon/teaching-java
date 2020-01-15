package pl.smtc.basics.string.conversions;

import pl.smtc.menu.ConsoleExample;

public class StringFromChars implements ConsoleExample {
    @Override
    public void execute() {
        String aChar = String.valueOf('a');
        System.out.println("Char \'a\' to String: " + aChar);
        String abChar = String.valueOf(new char[]{'a', 'b'});
        System.out.println("Chars \'ab\' to String: " + abChar);
        String bcChar = String.valueOf(new char[]{'a', 'b', 'c', 'd'}, 1,2);
        System.out.println("Char \'bc\' to String: " + bcChar);
    }

    @Override
    public String getName() {
        return "Char(s) to string";
    }
}
