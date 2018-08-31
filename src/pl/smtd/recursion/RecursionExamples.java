package pl.smtd.recursion;

import pl.smtd.menu.ConsoleMenu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecursionExamples {
    public void select() {
        List<String> availableOptions = new ArrayList<>(
                Arrays.asList("test1", "test2", "test3")
        );
        ConsoleMenu menu = new ConsoleMenu("Recursion example", 35, availableOptions);
        menu.show();
    }
}
