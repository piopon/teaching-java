package pl.smtd.recursion;

import pl.smtd.menu.ConsoleMenu;
import pl.smtd.menu.ConsoleExample;
import pl.smtd.recursion.dec2bin.DecimalToBinary;
import pl.smtd.recursion.divisor.CommonDivisor;
import pl.smtd.recursion.factorial.Factorial;
import pl.smtd.recursion.fibonacci.Fibonacci;
import pl.smtd.recursion.list.LinkedList;
import pl.smtd.recursion.power.QuickPower;

import java.util.*;

public class RecursionExamples implements ConsoleExample {
    Map<Integer, ConsoleExample> recursionExamples = new HashMap<>();
    private int menuWidth = 35;

    @Override
    public void execute() {
        addExamples(new Factorial(), new Fibonacci(),
                    new DecimalToBinary(), new CommonDivisor(),
                    new QuickPower(), new LinkedList());

        ConsoleMenu recursionMenu = new ConsoleMenu(getName(), menuWidth, recursionExamples);
        recursionMenu.show();
    }

    @Override
    public String getName() {
        return "Recursion examples";
    }

    private void addExamples(ConsoleExample... exercises) {
        for(int i = 0; i < exercises.length; i++) {
            recursionExamples.put(i, exercises[i]);
        }
    }

}
