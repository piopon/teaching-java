package pl.smtc.algorithms.sort.heap;

import pl.smtc.algorithms.sort.comparator.SortExample;
import pl.smtc.menu.ConsoleExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeapSort implements ConsoleExample, SortExample {

    @Override
    public void execute() {
        List<Integer> toSort = Arrays.asList(10, -9, 1, 0, -1, 4, 3, -3, 1, 2);
        System.out.println("TO SORT: " + toSort);
        System.out.println("SORTED:  " + sort(toSort));
    }

    @Override
    public String getName() {
        return "Heap sort";
    }

    public List<Integer> sort(final List<Integer> input) {
        List<Integer> result = new ArrayList<>(input);

        for (int i = result.size() / 2 - 1; i >= 0; i--) {
            createHeap(result, result.size(), i);
        }

        for (int i = result.size() - 1; i >= 0; i--) {
            int tempElement = result.get(0);
            result.set(0, result.get(i));
            result.set(i, tempElement);
            createHeap(result, i, 0);
        }
        return result;
    }

    private void createHeap(List<Integer> input, int size, int node) {
        int largest = node;
        int left = 2 * node + 1;
        int right = 2 * node + 2;

        if (left < size && input.get(left) > input.get(largest)) {
            largest = left;
        }

        if (right < size && input.get(right) > input.get(largest)) {
            largest = right;
        }

        if (largest != node) {
            int swap = input.get(node);
            input.set(node, input.get(largest));
            input.set(largest, swap);
            createHeap(input, size, largest);
        }
    }
}
