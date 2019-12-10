package pl.smtc.basics.operators.relational;

import pl.smtc.menu.ConsoleExample;

import java.util.Scanner;

public class RelationalOperators implements ConsoleExample {
    private final static int COMPARED_VALUE = 10;

    @Override
    public void execute() {
        System.out.print("Input value: ");
        int inputValue = new Scanner(System.in).nextInt();
        boolean check = inputValue == COMPARED_VALUE;
        System.out.println("Is " + inputValue + " == " + COMPARED_VALUE + "? " + check);
        check = inputValue != COMPARED_VALUE;
        System.out.println("Is " + inputValue + " != " + COMPARED_VALUE + "? " + check);
        check = inputValue > COMPARED_VALUE;
        System.out.println("Is " + inputValue + " > " + COMPARED_VALUE + "? " + check);
        check = inputValue >= COMPARED_VALUE;
        System.out.println("Is " + inputValue + " >= " + COMPARED_VALUE + "? " + check);
        check = inputValue < COMPARED_VALUE;
        System.out.println("Is " + inputValue + " < " + COMPARED_VALUE + "? " + check);
        check = inputValue <= COMPARED_VALUE;
        System.out.println("Is " + inputValue + " <= " + COMPARED_VALUE + "? " + check);
    }

    @Override
    public String getName() {
        return "Relational operators";
    }
}
