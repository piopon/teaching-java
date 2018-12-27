package pl.smtc.algorithms.sort.merge;

import pl.smtc.menu.ConsoleExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort implements ConsoleExample {

    @Override
    public void execute() {
        List<Integer> toSort = Arrays.asList(10, -9, 1, 0, -1, 4, 3, -3, 1, 2);
        System.out.println("TO SORT: " + toSort);
        System.out.println("SORTED:  " + sort(toSort));
    }

    @Override
    public String getName() {
        return "Merge sort";
    }

    public List<Integer> sort(final List<Integer> input) {
        List<Integer> resultSorted = new ArrayList<>(input);
        sort(resultSorted,0, input.size() - 1);

        return resultSorted;
    }

    private void sort(List<Integer> input, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int middleIndex = startIndex + (endIndex - startIndex) / 2;
            sort(input, startIndex, middleIndex);
            sort(input, middleIndex + 1, endIndex);
            merge(input, startIndex, middleIndex, endIndex);
        }
    }

    private void merge(List<Integer> input, int startIndex, int middleIndex, int endIndex) {
        Integer[] helpNumbers = new Integer[input.size()];
        for (int i = startIndex; i <= endIndex; i++) {
            helpNumbers[i] = input.get(i);
        }

        int start = startIndex, end = middleIndex + 1, current = startIndex;
        while (start <= middleIndex && end <= endIndex) {
            if (helpNumbers[start] <= helpNumbers[end]) {
                input.set(current++, helpNumbers[start++]);
            } else {
                input.set(current++, helpNumbers[end++]);
            }
        }

        while (start <= middleIndex) {
            input.set(current++, helpNumbers[start++]);
        }
    }
}
