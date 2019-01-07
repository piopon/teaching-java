package pl.smtc.algorithms.search;

import pl.smtc.algorithms.search.binary.BinarySearch;
import pl.smtc.algorithms.search.exponential.ExponentialSearch;
import pl.smtc.algorithms.search.interpolation.InterpolationSearch;
import pl.smtc.algorithms.search.jump.JumpSearch;
import pl.smtc.algorithms.search.linear.LinearSearch;
import pl.smtc.menu.ConsoleExample;
import pl.smtc.menu.ConsoleMenu;

import java.util.HashMap;
import java.util.Map;

public class SearchAlgorithms implements ConsoleExample {
    private Map<Integer, ConsoleExample> searchAlgorithms = new HashMap<>();
    private int menuWidth = 35;

    @Override
    public void execute() {
        addExamples(new LinearSearch(), new BinarySearch(), new JumpSearch(),
                    new InterpolationSearch(), new ExponentialSearch());

        ConsoleMenu searchAlgorithmsMenu = new ConsoleMenu(getName(), menuWidth, searchAlgorithms);
        searchAlgorithmsMenu.show();
    }

    @Override
    public String getName() {
        return "Search algorithms";
    }

    private void addExamples(ConsoleExample... examples) {
        for (int i = 0; i < examples.length; i++) {
            searchAlgorithms.put(i, examples[i]);
        }
    }
}
