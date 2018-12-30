package pl.smtc.algorithms.sort.cocktail;

import pl.smtc.menu.ConsoleExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CocktailSort implements ConsoleExample {

    @Override
    public void execute() {
        List<Integer> toSort = Arrays.asList(10, -9, 1, 0, -1, 4, 3, -3, 1, 2);
        System.out.println("TO SORT: " + toSort);
        System.out.println("SORTED:  " + sort(toSort));
    }

    @Override
    public String getName() {
        return "Cocktail sort";
    }

    public List<Integer> sort(final List<Integer> input) {
        List<Integer> result = new ArrayList<>(input);
        boolean swapped = true;
        int start = 0, end = input.size();

        while (swapped) {
            swapped = scanToEnd(result, start, end);
            if (swapped) {
                end--;
                swapped = scanToFront(result, start, end);
                start++;
            }
        }
        return result;
    }

    private boolean scanToEnd(final List<Integer> list, int startIndex, int stopIndex) {
        boolean swapMade = false;
        for (int i = startIndex; i < stopIndex - 1; ++i) {
            if (list.get(i) > list.get(i+1)) {
                swap(list, i, i+1);
                swapMade = true;
            }
        }
        return swapMade;
    }

    private boolean scanToFront(final List<Integer> list, int startIndex, int stopIndex) {
        boolean swapMade = false;
        for (int i = stopIndex - 1; i >= startIndex; i--) {
            if (list.get(i) > list.get(i+1)) {
                swap(list, i, i+1);
                swapMade = true;
            }
        }
        return swapMade;
    }

    private void swap(List<Integer> list, int firstIndex, int secondIndex) {
        int temp = list.get(firstIndex);
        list.set(firstIndex, list.get(secondIndex));
        list.set(secondIndex, temp);
    }
}
