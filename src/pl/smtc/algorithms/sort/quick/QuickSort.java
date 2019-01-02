package pl.smtc.algorithms.sort.quick;

import pl.smtc.algorithms.sort.comparator.SortExample;
import pl.smtc.menu.ConsoleExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort implements ConsoleExample, SortExample {
    
    @Override
    public void execute() {
        List<Integer> toSort = Arrays.asList(10, -9, 1, 0, -1, 4, 3, -3, 1, 2);
        System.out.println("TO SORT: " + toSort);
        System.out.println("SORTED:  " + sort(toSort));
    }

    @Override
    public String getName() {
        return "Quick sort";
    }

    public List<Integer> sort(final List<Integer> input) {
        List<Integer> result = new ArrayList<>(input);
        sort(result, 0, result.size() - 1);

        return result;
    }

    private void sort(final List<Integer> list, int start, int end) {
        int idx = partition(list, start, end);
        if (start < idx - 1) {
            sort(list, start, idx - 1);
        }
        if (end > idx) {
            sort(list, idx, end);
        }
    }

    private int partition(final List<Integer> list, int left, int right) {
        int pivot = list.get(left);
        while (left <= right) {
            while (list.get(left) < pivot) {
                left++;
            }
            while (list.get(right) > pivot) {
                right--;
            }
            if (left <= right) {
                int tmp = list.get(left);
                list.set(left, list.get(right));
                list.set(right, tmp);
                left++;
                right--;
            }
        }
        return left;
    }
}
