package pl.smtc.basics.operators;

import pl.smtc.basics.operators.arithmetic.ArithmeticOperators;
import pl.smtc.basics.operators.arithmetic.UnaryOperators;
import pl.smtc.basics.operators.bitwise.BitwiseOperators;
import pl.smtc.basics.operators.bitwise.ShiftOperators;
import pl.smtc.basics.operators.relational.ConditionalOperators;
import pl.smtc.basics.operators.relational.RelationalOperators;
import pl.smtc.menu.ConsoleExample;
import pl.smtc.menu.ConsoleMenu;

import java.util.HashMap;
import java.util.Map;

public class Operators implements ConsoleExample {
    private Map<Integer, ConsoleExample> operatorsExamples = new HashMap<>();
    private int menuWidth = 35;

    @Override
    public void execute() {
        addExamples(new ArithmeticOperators(), new UnaryOperators(),
                    new ConditionalOperators(), new RelationalOperators(),
                    new BitwiseOperators(), new ShiftOperators());

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
