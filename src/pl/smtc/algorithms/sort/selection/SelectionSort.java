package pl.smtc.algorithms.sort.selection;

import pl.smtc.algorithms.sort.comparator.SortExample;
import pl.smtc.menu.ConsoleExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectionSort implements ConsoleExample, SortExample {

    @Override
    public void execute() {
        List<Integer> toSort = Arrays.asList(10, -9, 1, 0, -1, 4, 3, -3, 1, 2);
        System.out.println("TO SORT: " + toSort);
        System.out.println("SORTED:  " + sort(toSort));
    }

    @Override
    public String getName() {
        return "Selection sort";
    }

    public List<Integer> sort(final List<Integer> input) {
        List<Integer> result = new ArrayList<>(input);
        for (int i = 0; i < input.size() - 1; i++) {
            int minimumIndex = findMinimumIndex(result, i);
            int temp = result.get(minimumIndex);
            result.set(minimumIndex, result.get(i));
            result.set(i, temp);
        }
        return result;
    }

    private int findMinimumIndex(List<Integer> source, int startIndex) {
        int minimumIndex = startIndex;
        for (int j = startIndex + 1; j < source.size(); j++) {
            if (source.get(j) < source.get(minimumIndex)) {
                minimumIndex = j;
            }
        }
        return minimumIndex;
    }
}
