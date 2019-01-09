package pl.smtc.algorithms.search.exponential;

import pl.smtc.algorithms.search.comparator.SearchExample;
import pl.smtc.menu.ConsoleExample;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class ExponentialSearch implements ConsoleExample, SearchExample {

    @Override
    public void execute() {
        try {
            int toFind = 3;
            List<Integer> list = Arrays.asList(-9, -3, -1, 0, 1, 1, 2, 3, 4, 10);
            System.out.println("SEARCH: " + list);
            System.out.println("RESULT: item '" + toFind + "' found at index: " + find(list, toFind));
        } catch (NoSuchElementException e) {
            System.out.println("ERROR!  " + e.getMessage());
        }
    }

    @Override
    public String getName() {
        return "Exponential search";
    }

    @Override
    public int find(final List<Integer> list, int elementToFind) throws NoSuchElementException {
        if (list.get(0) == elementToFind) {
            return 0;
        }
        int startIndex = getStartIndex(list, elementToFind);
        int fromIndex = startIndex/2, toIndex = Math.min(startIndex, list.size());
        int found = Arrays.binarySearch(list.toArray(), fromIndex, toIndex, elementToFind);
        if (found >= 0) {
            return found;
        }
        throw new NoSuchElementException("Cannot find element '" + elementToFind + "' in list.");
    }

    private int getStartIndex(final List<Integer> list, int elementToFind) {
        int index = 1;
        while (index < list.size() && list.get(index) <= elementToFind) {
            index = index * 2;
        }
        return index;
    }
}
