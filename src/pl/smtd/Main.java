package pl.smtd;

import pl.smtd.menu.ConsoleExercise;
import pl.smtd.menu.ConsoleMenu;
import pl.smtd.recursion.RecursionExamples;
import pl.smtd.recursion.RecursionTest1;
import pl.smtd.recursion.RecursionTest2;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<Integer, ConsoleExercise> EXAMPLES = new HashMap<>();

    public static void main(String[] args) {
        addExamples(new RecursionExamples());

        ConsoleMenu topMenu = new ConsoleMenu("Main menu", 35, EXAMPLES);
        topMenu.show();
    }

    private static void addExamples(ConsoleExercise... exercises) {
        for(int i = 0; i < exercises.length; i++) {
            EXAMPLES.put(i, exercises[i]);
        }
    }
}
