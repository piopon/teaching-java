package pl.smtc.recursion;

import pl.smtc.menu.ConsoleMenu;
import pl.smtc.menu.ConsoleExample;
import pl.smtc.recursion.dec2bin.DecimalToBinary;
import pl.smtc.recursion.directories.TreeExplorer;
import pl.smtc.recursion.divisor.CommonDivisor;
import pl.smtc.recursion.factorial.Factorial;
import pl.smtc.recursion.fibonacci.Fibonacci;
import pl.smtc.recursion.list.LinkedList;
import pl.smtc.recursion.power.QuickPower;
import pl.smtc.recursion.sort.QuickSort;

import java.util.*;

public class RecursionExamples implements ConsoleExample {
    Map<Integer, ConsoleExample> recursionExamples = new HashMap<>();
    private int menuWidth = 35;

    @Override
    public void execute() {
        addExamples(new Factorial(), new Fibonacci(),
                    new DecimalToBinary(), new CommonDivisor(),
                    new QuickPower(), new LinkedList(),
                    new TreeExplorer(), new QuickSort());

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
