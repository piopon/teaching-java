package pl.smtc.algorithms.sort.bubble;

import pl.smtc.menu.ConsoleExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BubbleSort implements ConsoleExample {
    private int scansCounter;

    @Override
    public void execute() {
        List<Integer> toSort = Arrays.asList(10, -9, 1, 0, -1, 4, 3, -3, 1, 2);
        System.out.println("TO SORT: " + toSort);
        System.out.println("SORTED:");
        System.out.println(" - NORMAL = " + sort(toSort) + " -> " + scansCounter + " scans");
        System.out.println(" - FAST   = " + sortFast(toSort) + " -> " + scansCounter + " scans");
    }

    @Override
    public String getName() {
        return "Bubble sort";
    }

    public List<Integer> sort(final List<Integer> input) {
        List<Integer> result = new ArrayList<>(input);
        for (scansCounter = 0; scansCounter < input.size(); scansCounter++) {
            for (int j = 0; j < input.size() - scansCounter - 1; j++) {
                if(result.get(j) > result.get(j+1)) {
                    int temp = result.get(j);
                    result.set(j, result.get(j+1));
                    result.set(j+1, temp);
                }
            }
        }
        return result;
    }

    public List<Integer> sortFast(List<Integer> input) {
        List<Integer> result = new ArrayList<>(input);
        for (scansCounter = 0; scansCounter < input.size(); scansCounter++) {
            boolean swapped = false;
            for (int j = 0; j < input.size() - scansCounter - 1; j++) {
                if(result.get(j) > result.get(j+1)) {
                    int temp = result.get(j);
                    result.set(j, result.get(j+1));
                    result.set(j+1, temp);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return result;
    }
}
