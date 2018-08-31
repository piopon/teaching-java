package pl.smtd.recursion;

import pl.smtd.menu.ConsoleMenu;
import pl.smtd.menu.ConsoleExercise;

import java.util.*;

public class RecursionExamples {
    Map<Integer, ConsoleExercise> recursionExamples = new HashMap<>();

    public void select() {
        addExamples();

        ConsoleMenu recursionMenu = new ConsoleMenu("Recursion example", 35, recursionExamples);
        recursionMenu.show();
    }

    private void addExamples(ConsoleExercise... exercises) {
        for(int i = 0; i < exercises.length; i++) {
            recursionExamples.put(i, exercises[i]);
        }
    }
}
