package pl.smtc.algorithms;

import pl.smtc.algorithms.math.MathAlgorithms;
import pl.smtc.algorithms.search.SearchAlgorithms;
import pl.smtc.algorithms.sort.SortAlgorithms;
import pl.smtc.menu.ConsoleExample;
import pl.smtc.menu.ConsoleMenu;

import java.util.HashMap;
import java.util.Map;

public class AlgorithmsExamples implements ConsoleExample {
    private Map<Integer, ConsoleExample> algorithmExamples = new HashMap<>();
    private int menuWidth = 35;

    @Override
    public void execute() {
        addExamples(new SortAlgorithms(), new SearchAlgorithms(), new MathAlgorithms());

        ConsoleMenu algorithmsMenu = new ConsoleMenu(getName(), menuWidth, algorithmExamples);
        algorithmsMenu.show();
    }

    @Override
    public String getName() {
        return "Algorithm examples";
    }

    private void addExamples(ConsoleExample... examples) {
        for(int i = 0; i < examples.length; i++) {
            algorithmExamples.put(i, examples[i]);
        }
    }
}
