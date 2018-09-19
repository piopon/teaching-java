package pl.smtc.recursion.sort;

import pl.smtc.menu.ConsoleExample;

import java.util.Arrays;

public class QuickSort implements ConsoleExample {
    
    @Override
    public void execute() {
        int[] input = {23, 31, 1, 21, 36, 72, 100, -10, 0, 23};
        System.out.println("TO SORT: " + Arrays.toString(input));
        int[] sorted = sort(input, 0, input.length - 1);
        System.out.println("RESULT:  " + Arrays.toString(sorted));
    }

    @Override
    public String getName() {
        return "Quick sort";
    }

    public int[] sort(int[] array, int start, int end) {
        int[] output = array;
        int idx = partition(array, start, end);
        if (start < idx - 1) {
            output = sort(array, start, idx - 1);
        }
        if (end > idx) {
            output = sort(array, idx, end);
        }
        return output;
    }

    private int partition(int[] array, int left, int right) {
        int pivot = array[left];
        while (left <= right) {
            while (array[left] < pivot) {
                left++;
            }
            while (array[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
                left++;
                right--;
            }
        }
        return left;
    }
}
