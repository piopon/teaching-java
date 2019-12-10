package pl.smtc.basics.operators.arithmetic;

import pl.smtc.menu.ConsoleExample;

import java.util.Scanner;

public class UnaryOperators implements ConsoleExample {
    @Override
    public void execute() {
        System.out.print("Input startup value: ");
        int inputValue = new Scanner(System.in).nextInt();
        unaryNumeric(inputValue);
        unaryBoolean(false);
    }

    @Override
    public String getName() {
        return "Unary operators";
    }

    private void unaryNumeric(int input) {
        System.out.println("------------------");
        System.out.println("Input value: " + input);
        input--;
        System.out.println("Decrement operator: " + input);
        input++;
        System.out.println("Increment operator: " + input);
        input = -input;
        System.out.println("Negate expression: " + input);
    }

    private void unaryBoolean(boolean input) {
        System.out.println("------------------");
        System.out.println("Input bool value: " + input);
        System.out.println("Negate bool: " + !input);
    }
}
