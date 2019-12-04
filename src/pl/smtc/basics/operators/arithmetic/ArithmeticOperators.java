package pl.smtc.basics.operators.arithmetic;

import pl.smtc.menu.ConsoleExample;

import java.util.Scanner;

public class ArithmeticOperators implements ConsoleExample {
    @Override
    public void execute() {
        System.out.print("Input startup value: ");
        int valueA = new Scanner(System.in).nextInt();
        int valueB = valueA + 5;
        System.out.println(valueA + " + 5 = " + valueB);
        valueA = valueB - 1;
        System.out.println(valueB + " - 1 = " + valueA);
        valueB = valueA * 2;
        System.out.println(valueA + " * 2 = " + valueB);
        valueA = valueB / 2;
        System.out.println(valueB + " / 2 = " + valueA);
        valueB = valueA + 8;
        System.out.println(valueA + " + 8 = " + valueB);
        valueA = valueB % 7;
        System.out.println(valueB + " % 7 = " + valueA);
    }

    @Override
    public String getName() {
        return "Arithmetic operators";
    }
}
