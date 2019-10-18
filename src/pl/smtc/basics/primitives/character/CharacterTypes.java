package pl.smtc.basics.primitives.character;

import pl.smtc.menu.ConsoleExample;

public class CharacterTypes implements ConsoleExample {
    @Override
    public void execute() {
        char pChar = 'P';
        char nChar ='\u0418';
        char kChar ='\u049E';
        System.out.println("Unicode characters example: " + pChar + nChar + kChar + " \u06E9 2019");

        printSummary();
    }

    @Override
    public String getName() {
        return "Character types";
    }

    private void printSummary() {
        System.out.println("-------------------------------------------");
        System.out.println("Character types summary");
        System.out.println(getTypeSummary("char", Character.SIZE, Character.BYTES, Character.MIN_VALUE, Character.MAX_VALUE));
    }

    private String getTypeSummary(String title, int size, int bytes, int min, int max) {
        String values = "\tsize = " + size + ", bytes = " + bytes + ", min value = " + min + ", max value = " + max;
        return " - " + title + ": " + values;
    }
}
