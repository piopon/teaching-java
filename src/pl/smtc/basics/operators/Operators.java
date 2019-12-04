package pl.smtc.basics.operators;

import pl.smtc.basics.operators.arithmetic.ArithmeticOperators;
import pl.smtc.menu.ConsoleExample;
import pl.smtc.menu.ConsoleMenu;

import java.util.HashMap;
import java.util.Map;

public class Operators implements ConsoleExample {
    private Map<Integer, ConsoleExample> operatorsExamples = new HashMap<>();
    private int menuWidth = 35;

    @Override
    public void execute() {
        addExamples(new ArithmeticOperators());

        ConsoleMenu operatorsMenu = new ConsoleMenu(getName(), menuWidth, operatorsExamples);
        operatorsMenu.show();
    }

    @Override
    public String getName() {
        return "Operators";
    }

    private void addExamples(ConsoleExample... examples) {
        for(int i = 0; i < examples.length; i++) {
            operatorsExamples.put(i, examples[i]);
        }
    }
}
