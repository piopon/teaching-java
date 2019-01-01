package pl.smtc.algorithms.sort.bitonic;

import pl.smtc.menu.ConsoleExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BitonicSort implements ConsoleExample {
    private enum Direction {
        ASCEND,
        DESCEND
    }

    @Override
    public void execute() {
        List<Integer> toSort = Arrays.asList(10, -9, 1, 0, -3, 4, -1, 3, 1, 2);
        System.out.println("TO SORT: " + toSort);
        System.out.println("SORTED:  " + sort(toSort));
    }

    @Override
    public String getName() {
        return "Bitonic sort";
    }

    public List<Integer> sort(final List<Integer> input) {
        List<Integer> result = new ArrayList<>(input);

        sort(result, 0, result.size(), Direction.ASCEND);

        return result;
    }

    private void sort(final List<Integer> list, int low, int cnt, Direction dir) {
        if (cnt>1) {
            int k = cnt/2;
            sort(list, low, k, Direction.DESCEND);
            sort(list,low+k, cnt-k, Direction.ASCEND);
            merge(list, low, cnt, dir);
        }
    }

    private void compareAndSwap(final List<Integer> list, int index1, int index2, Direction dir) {
        boolean doSwap = false;
        if (dir == Direction.ASCEND) {
            doSwap = list.get(index1) > list.get(index2);
        } else if (dir == Direction.DESCEND) {
            doSwap = list.get(index1) < list.get(index2);
        }
        if (doSwap) {
            int temp = list.get(index1);
            list.set(index1, list.get(index2));
            list.set(index2, temp);
        }
    }

    private void merge(final List<Integer> list, int low, int cnt, Direction dir) {
        if (cnt>1) {
            int m = greatestPowerOfTwoLessThan(cnt);
            for (int i = low; i < low+cnt-m; i++) {
                compareAndSwap(list, i, i + m, dir);
            }
            merge(list, low, m, dir);
            merge(list,low+m, cnt-m, dir);
        }
    }

    private int greatestPowerOfTwoLessThan(int n) {
        int k=1;
        while (k>0 && k<n) {
            k=k<<1;
        }
        return k>>>1;
    }
}
