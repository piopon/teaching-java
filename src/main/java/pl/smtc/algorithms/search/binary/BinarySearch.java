package pl.smtc.algorithms.search.binary;

import pl.smtc.algorithms.search.comparator.SearchExample;
import pl.smtc.menu.ConsoleExample;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class BinarySearch implements ConsoleExample, SearchExample {

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
        return "Binary search";
    }

    @Override
    public int find(final List<Integer> list, int elementToFind) throws NoSuchElementException {
        int result = find(list, 0, list.size() - 1, elementToFind);
        if (result == -1) {
            throw new NoSuchElementException("Cannot find element '" + elementToFind + "' in list.");
        }
        return result;
    }

    private int find(final List<Integer> list, int start, int end, int elementToFind)
    {
        if (end >= start) {
            int mid = start + (end - start) / 2;
            if (list.get(mid) == elementToFind) {
                return mid;
            }
            if (list.get(mid) > elementToFind) {
                return find(list, start, mid - 1, elementToFind);
            }
            return find(list, mid + 1, end, elementToFind);
        }
        return -1;
    }
}
