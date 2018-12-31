package pl.smtc.algorithms.sort.radix;

import pl.smtc.menu.ConsoleExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RadixSort implements ConsoleExample {
    private static final int CUTOFF = 15;
    private static final int BITS_PER_INT = 32;
    private static final int BITS_PER_BYTE = 8;
    private static final int R = 256;

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

        int firstPositiveIndex = partition(0, result);
        int[] aux = new int[result.size()];
        if (firstPositiveIndex > 0) {
            recSort(result, firstPositiveIndex, result.size() - 1, 0, aux);
            recSort(result, 0, firstPositiveIndex - 1, 0, aux);
        } else {
            recSort(result, 0, result.size() - 1, 0, aux);
        }
        return result;
    }

    private void recSort(final List<Integer> a, int lo, int hi, int d, int[] aux) {
        if (d > 4) return;
        if (hi - lo < CUTOFF) {
            insertionSort(a, lo, hi);
            return;
        }

        int[] count = new int[R + 1];

        int bitsToShift = BITS_PER_INT - BITS_PER_BYTE * d - BITS_PER_BYTE;
        int mask = 0b1111_1111;
        for (int i = lo; i <= hi; i++) {
            int c = (a.get(i) >> bitsToShift) & mask;
            count[c + 1]++;
        }

        for (int i = 0; i < R; i++) {
            count[i + 1] = count[i] + count[i + 1];
        }

        for (int i = lo; i <= hi; i++) {
            int c = (a.get(i) >> bitsToShift) & mask;
            aux[count[c] + lo] = a.get(i);
            count[c]++;
        }

        for (int i = lo; i <= hi; i++) {
            a.set(i, aux[i]);
        }

        if (count[0] > 0) {
            recSort(a, lo, lo + count[0] - 1, d + 1, aux);
        }

        for (int i = 1; i < R; i++) {
            if (count[i] > 0) {
                recSort(a, lo + count[i - 1], lo + count[i] - 1, d + 1, aux);
            }
        }
    }

    private void insertionSort(final List<Integer> a, int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && a.get(j) < a.get(j - 1); j--) {
                swap(a, j, j - 1);
            }
        }
    }

    private int partition(int pivot, List<Integer> a) {
        int curLo = 0;
        int curHi = a.size()-1;

        while (curLo < curHi) {

            while (a.get(curLo) < pivot) {
                if ((curLo + 1) > a.size()-1) {
                    return a.size();
                }
                curLo++;
            }

            while (a.get(curHi) >= pivot) {
                if ((curHi - 1) < 0) {
                    return - 1;
                }
                curHi--;
            }

            if (curLo < curHi) {
                swap(a, curLo, curHi);
                if (a.get(curLo) != pivot) curLo++;
                if (a.get(curHi) != pivot) curHi--;
            }
        }
        return curLo;
    }

    private void swap(final List<Integer> list, int firstIndex, int secondIndex) {
        int t = list.get(firstIndex);
        list.set(firstIndex, list.get(secondIndex));
        list.set(secondIndex, t);
    }
}


