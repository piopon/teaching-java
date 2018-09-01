package pl.smtd.recursion;

import pl.smtd.menu.ConsoleMenu;
import pl.smtd.menu.ConsoleExercise;

import java.util.*;

public class RecursionExamples implements ConsoleExercise {
    Map<Integer, ConsoleExercise> recursionExamples = new HashMap<>();
    private int menuWidth = 35;

    @Override
    public void execute() {
        addExamples(new RecursionTest1(),
                    new RecursionTest2());

        ConsoleMenu recursionMenu = new ConsoleMenu(getName(), menuWidth, recursionExamples);
        recursionMenu.show();
    }

    @Override
    public String getName() {
        return "Recursion examples";
    }

    private void addExamples(ConsoleExercise... exercises) {
        for(int i = 0; i < exercises.length; i++) {
            recursionExamples.put(i, exercises[i]);
        }
    }

}
