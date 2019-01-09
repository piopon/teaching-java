package pl.smtc.algorithms.search.jump;

import pl.smtc.algorithms.search.comparator.SearchExample;
import pl.smtc.menu.ConsoleExample;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class JumpSearch implements ConsoleExample, SearchExample {

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
        return "Jump search";
    }

    @Override
    public int find(final List<Integer> list, int elementToFind) throws NoSuchElementException {
        int blockSize = (int)Math.floor(Math.sqrt(list.size()));
        int prev = findContainingBlock(list, blockSize, elementToFind);

        while (list.get(prev) < elementToFind) {
            prev++;
            if (prev == Math.min(blockSize, list.size())) {
                break;
            }
        }
        if (list.get(prev) == elementToFind) {
            return prev;
        }
        throw new NoSuchElementException("Cannot find element '" + elementToFind + "' in list.");
    }

    private int findContainingBlock(final List<Integer> list, int blockSize, final int elementToFind) {
        int prev = 0;
        while (list.get(Math.min(blockSize, list.size()) - 1) < elementToFind) {
            prev = blockSize;
            blockSize += (int)Math.floor(Math.sqrt(list.size()));
            if (prev >= list.size()) {
                throw new NoSuchElementException("Cannot find element '" + elementToFind + "' in list.");
            }
        }
        return prev;
    }
}
