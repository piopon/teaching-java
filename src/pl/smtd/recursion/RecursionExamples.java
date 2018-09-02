package pl.smtd.recursion;

import pl.smtd.menu.ConsoleMenu;
import pl.smtd.menu.ConsoleExample;

import java.util.*;

public class RecursionExamples implements ConsoleExample {
    Map<Integer, ConsoleExample> recursionExamples = new HashMap<>();
    private int menuWidth = 35;

    @Override
    public void execute() {
        addExamples(new DecimalToBinary(), new Fibonacci(), new QuickPower());

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
