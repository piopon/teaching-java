package pl.smtc.algorithms.search.interpolation;

import pl.smtc.algorithms.search.comparator.SearchExample;
import pl.smtc.menu.ConsoleExample;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class InterpolationSearch implements ConsoleExample, SearchExample {

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
        return "Interpolation search";
    }

    @Override
    public int find(final List<Integer> list, int elementToFind) throws NoSuchElementException {
        int start = 0, end = list.size() - 1;
        while (start <= end && elementToFind >= list.get(start) && elementToFind <= list.get(end)) {
            int offset = (start == end) ? 0 : getSearchOffset(list, start, end, elementToFind);
            int pos = start + offset;
            if (list.get(pos) == elementToFind) {
                return pos;
            }
            if (list.get(pos) < elementToFind) {
                start = pos + 1;
            } else {
                end = pos - 1;
            }
        }
        throw new NoSuchElementException("Cannot find element '" + elementToFind + "' in list.");
    }

    private int getSearchOffset(List<Integer> list, int startIndex, int endIndex, int findElement) {
        int range = list.get(endIndex) - list.get(startIndex);
        if (range == 0) {
            range = 1;
        }
        return (((endIndex - startIndex) / range) * (findElement - list.get(startIndex)));
    }
}
