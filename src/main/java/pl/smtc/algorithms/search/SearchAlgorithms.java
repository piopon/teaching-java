package pl.smtc.algorithms.search;

import pl.smtc.algorithms.search.binary.BinarySearch;
import pl.smtc.algorithms.search.comparator.SearchComparator;
import pl.smtc.algorithms.search.comparator.SearchExample;
import pl.smtc.algorithms.search.exponential.ExponentialSearch;
import pl.smtc.algorithms.search.fibonacci.FibonacciSearch;
import pl.smtc.algorithms.search.interpolation.InterpolationSearch;
import pl.smtc.algorithms.search.jump.JumpSearch;
import pl.smtc.algorithms.search.linear.LinearSearch;
import pl.smtc.menu.ConsoleExample;
import pl.smtc.menu.ConsoleMenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchAlgorithms implements ConsoleExample {
    private Map<Integer, ConsoleExample> searchAlgorithms = new HashMap<>();
    private int menuWidth = 35;

    @Override
    public void execute() {
        addExamples(new LinearSearch(), new BinarySearch(), new JumpSearch(),
                    new InterpolationSearch(), new ExponentialSearch(),
                    new FibonacciSearch(), createComparatorExample());

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

    private ConsoleExample createComparatorExample() {
        return new SearchComparator(addComparatorExamples(new LinearSearch(),
                new BinarySearch(), new JumpSearch(), new InterpolationSearch(),
                new ExponentialSearch(), new FibonacciSearch()));
    }

    private List<SearchExample> addComparatorExamples(SearchExample... examples) {
        List<SearchExample> comparatorExamples = new ArrayList<>();
        for (int i = 0; i < examples.length; i++) {
            comparatorExamples.add(examples[i]);
        }
        return comparatorExamples;
    }
}
