package pl.smtc.algorithms.search.fibonacci;

import pl.smtc.algorithms.search.comparator.SearchExample;
import pl.smtc.menu.ConsoleExample;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class FibonacciSearch implements ConsoleExample, SearchExample {

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
        return "Fibonacci search";
    }

    @Override
    public int find(final List<Integer> list, int elementToFind) throws NoSuchElementException {
        int fibM2 = 0, fibM1 = 1, fibM = fibM2 + fibM1;
        while (fibM < list.size()) {
            fibM2 = fibM1;
            fibM1 = fibM;
            fibM = fibM2 + fibM1;
        }

        int offset = -1;
        while (fibM > 1) {
            int i = Math.min(offset+fibM2, list.size() - 1);
            if (list.get(i) < elementToFind) {
                fibM = fibM1;
                fibM1 = fibM2;
                fibM2 = fibM - fibM1;
                offset = i;
            } else if (list.get(i) > elementToFind) {
                fibM = fibM2;
                fibM1 = fibM1 - fibM2;
                fibM2 = fibM - fibM1;
            } else {
                return i;
            }
        }

        if(fibM1 == 1 && list.get(offset+1) == elementToFind) {
            return offset + 1;
        }
        throw new NoSuchElementException("Cannot find element '" + elementToFind + "' in list.");
    }
}
