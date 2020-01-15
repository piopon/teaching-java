package pl.smtc.algorithms.search.comparator;

import java.util.List;
import java.util.NoSuchElementException;

public interface SearchExample {

    int find(final List<Integer> list, int elementToFind) throws NoSuchElementException;

    String getName();
}
