package pl.smtc.algorithms.sort.radix;

import pl.smtc.algorithms.sort.comparator.SortExample;
import pl.smtc.menu.ConsoleExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RadixSort implements ConsoleExample, SortExample {
    private static final int BYTE_MASK = 0b1111_1111;
    private static final int BYTE_MAX = 256;

    @Override
    public void execute() {
        List<Integer> toSort = Arrays.asList(10, -9, 1, 0, -1, 4, 3, -3, 1, 2);
        System.out.println("TO SORT: " + toSort);
        System.out.println("SORTED:  " + sort(toSort));
    }

    @Override
    public String getName() {
        return "Radix sort";
    }

    public List<Integer> sort(final List<Integer> input) {
        List<Integer> result = new ArrayList<>(input);

        int positiveIndex = rearrangeList(result);
        int[] helpArray = new int[result.size()];
        if (positiveIndex > 0) {
            sort(result, positiveIndex, result.size()-1, 0, helpArray);
            sort(result, 0, positiveIndex-1, 0, helpArray);
        } else {
            sort(result, 0, result.size()-1, 0, helpArray);
        }
        return result;
    }

    private void sort(final List<Integer> list, int start, int end, int startByte, int[] help) {
        if (startByte > Integer.SIZE / Byte.SIZE) {
            return;
        }

        int[] count = new int[BYTE_MAX + 1];
        int bitsToShift = Integer.SIZE - Byte.SIZE * (startByte - 1);
        for (int i = start; i <= end; i++) {
            int c = (list.get(i) >> bitsToShift) & BYTE_MASK;
            count[c+1]++;
        }

        for (int i = 0; i < BYTE_MAX; i++) {
            count[i+1] = count[i] + count[i + 1];
        }

        for (int i = start; i <= end; i++) {
            int c = (list.get(i) >> bitsToShift) & BYTE_MASK;
            help[count[c] + start] = list.get(i);
            count[c]++;
        }

        for (int i = start; i <= end; i++) {
            list.set(i, help[i]);
        }

        if (count[0] > 0) {
            sort(list, start, start+count[0]-1, startByte+1, help);
        }

        for (int i = 1; i < BYTE_MAX; i++) {
            if (count[i] > 0) {
                sort(list, start+count[i-1], start+count[i]-1, startByte+1, help);
            }
        }
    }

    private int rearrangeList(final List<Integer> list) {
        int currentStart = 0;
        int currentStop = list.size()-1;

        while (currentStart <= currentStop) {
            while (list.get(currentStart) < 0) {
                if ((currentStart + 1) > list.size()-1) {
                    return list.size();
                }
                currentStart++;
            }
            while (list.get(currentStop) >= 0) {
                if ((currentStop - 1) < 0) {
                    return - 1;
                }
                currentStop--;
            }
            if (currentStart < currentStop) {
                swap(list, currentStart, currentStop);
                if (list.get(currentStart) != 0) currentStart++;
                if (list.get(currentStop) != 0) currentStop--;
            }
        }
        return currentStart;
    }

    private void swap(final List<Integer> list, int firstIndex, int secondIndex) {
        int t = list.get(firstIndex);
        list.set(firstIndex, list.get(secondIndex));
        list.set(secondIndex, t);
    }
}


