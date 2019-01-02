package pl.smtc.algorithms.sort.comb;

import pl.smtc.algorithms.sort.comparator.SortExample;
import pl.smtc.menu.ConsoleExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombSort implements ConsoleExample, SortExample {
    private static double SHRINK_FACTOR = 1.3;

    @Override
    public void execute() {
        List<Integer> toSort = Arrays.asList(10, -9, 1, 0, -1, 4, 3, -3, 1, 2);
        System.out.println("TO SORT: " + toSort);
        System.out.println("SORTED:  " + sort(toSort));
    }

    @Override
    public String getName() {
        return "Comb sort";
    }

    public List<Integer> sort(final List<Integer> input) {
        List<Integer> result = new ArrayList<>(input);
        int gap = input.size();
        boolean swapped = true;
        while (gap != 1 || swapped) {
            swapped = false;
            gap = shrinkGap(gap);
            for (int i=0; i < result.size() - gap; i++) {
                if (result.get(i) > result.get(i+gap)) {
                    swap(result, i, i+gap);
                    swapped = true;
                }
            }
        }
        return result;
    }

    private void swap(final List<Integer> list, int firstIndex, int secondIndex) {
        int temp = list.get(firstIndex);
        list.set(firstIndex, list.get(secondIndex));
        list.set(secondIndex, temp);
    }

    private int shrinkGap(int gap) {
        gap /= SHRINK_FACTOR;
        if (gap < 1) {
            gap = 1;
        }
        return gap;
    }
}
