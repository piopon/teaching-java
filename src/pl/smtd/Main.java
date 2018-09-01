package pl.smtd;

import pl.smtd.menu.ConsoleExample;
import pl.smtd.menu.ConsoleMenu;
import pl.smtd.recursion.RecursionExamples;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<Integer, ConsoleExample> EXAMPLES = new HashMap<>();

    public static void main(String[] args) {
        addExamples(new RecursionExamples());

        ConsoleMenu topMenu = new ConsoleMenu("Main menu", 35, EXAMPLES);
        topMenu.show();
    }

    private static void addExamples(ConsoleExample... exercises) {
        for(int i = 0; i < exercises.length; i++) {
            EXAMPLES.put(i, exercises[i]);
        }
    }
}
