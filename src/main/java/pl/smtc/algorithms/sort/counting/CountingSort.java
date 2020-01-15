package pl.smtc.algorithms.sort.counting;

import pl.smtc.algorithms.sort.comparator.SortExample;
import pl.smtc.menu.ConsoleExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountingSort implements ConsoleExample, SortExample {

    @Override
    public void execute() {
        List<Integer> toSort = Arrays.asList(10, -9, 1, 0, -1, 4, 3, -3, 1, 2);
        System.out.println("TO SORT: " + toSort);
        System.out.println("SORTED:  " + sort(toSort));
    }

    @Override
    public String getName() {
        return "Counting sort";
    }

    public List<Integer> sort(final List<Integer> input) {
        List<Integer> result = new ArrayList<>(input);

        int[] valuesCounter = countValues(input);
        int max = getMaxValue(input);
        int valueIndex = 0;
        int counterIndex = 0;

        while (valueIndex < result.size()) {
            if (valuesCounter[counterIndex] > 0) {
                valuesCounter[counterIndex]--;
                result.set(valueIndex, counterIndex-max);
                valueIndex++;
            } else {
                counterIndex++;
            }
        }
        return result;
    }

    private int[] countValues(final List<Integer> list) {
        int max = getMaxValue(list);
        int[] valuesCounter = new int[max * 2 + 1];
        for (int i = 0; i < list.size(); i++) {
            valuesCounter[list.get(i) + max]++;
        }
        return valuesCounter;
    }

    private int getMaxValue(final List<Integer> list) {
        int max = -1;
        for (int i = 0; i < list.size(); i++) {
            if (Math.abs(list.get(i)) > max) {
                max = Math.abs(list.get(i));
            }
        }
        return max;
    }
}
