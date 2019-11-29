package pl.smtc.basics.string.checks;

import pl.smtc.menu.ConsoleExample;

public class StringContents implements ConsoleExample {
    @Override
    public void execute() {
        String input = "Test string";
        System.out.println("Input string: " + input);
        boolean hasTest = input.contains("Test");
        System.out.println("Does have \'Test\' word: " + hasTest);
        boolean iPosOk = input.charAt(8) == 'i';
        System.out.println("Is \'i\' at pos 8: " + iPosOk);
        boolean iPosNok = input.charAt(5) == 'i';
        System.out.println("Is \'i\' at pos 5: " + iPosNok);
        boolean iCodeOk = input.codePointAt(8) == 0x69;
        System.out.println("Code point for \'i\' correct: " + iCodeOk);
        boolean rCodeOk = input.codePointBefore(8) == 0x72;
        System.out.println("Code point for \'r\' correct: " + rCodeOk);
        int codeSum = input.codePointCount(1,3);
        System.out.println("Code sum for test: " + codeSum);
    }

    @Override
    public String getName() {
        return "Content checks";
    }
}
