package pl.smtc.algorithms.sort.insertion;

import pl.smtc.algorithms.sort.comparator.SortExample;
import pl.smtc.menu.ConsoleExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertionSort implements ConsoleExample, SortExample {

    @Override
    public void execute() {
        List<Integer> toSort = Arrays.asList(10, -9, 1, 0, -1, 4, 3, -3, 1, 2);
        System.out.println("TO SORT: " + toSort);
        System.out.println("SORTED:  " + sort(toSort));
    }

    @Override
    public String getName() {
        return "Insertion sort";
    }

    public List<Integer> sort(final List<Integer> input) {
        List<Integer> result = new ArrayList<>(input);
        for (int i = 0; i < input.size(); i++) {
            int currentElement = result.get(i);
            int lastSortedIndex = i - 1;
            while(lastSortedIndex >= 0 && result.get(lastSortedIndex) > currentElement) {
                result.set(lastSortedIndex + 1, result.get(lastSortedIndex));
                lastSortedIndex -= 1;
            }
            result.set(lastSortedIndex + 1, currentElement);
        }
        return result;
    }
}
