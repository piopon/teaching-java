package pl.smtc.algorithms.sort;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class SortAlgorithmsTest extends BaseTestInOut {
    SortAlgorithms sortAlgorithms;

    @Override
    protected void setUp() {
        sortAlgorithms = new SortAlgorithms();
    }

    @Test
    void executeShouldInvokeSortAlgorithmsMenu() {
        simulateUserInput("0");
        sortAlgorithms.execute();
        String output = getOutput();
        assertTrue(output.contains("SORT ALGORITHMS"));
        assertTrue(output.contains("1) Bubble sort"));
        assertTrue(output.contains("2) Insertion sort"));
        assertTrue(output.contains("3) Quick sort"));
        assertTrue(output.contains("4) Selection sort"));
        assertTrue(output.contains("5) Merge sort"));
        assertTrue(output.contains("6) Heap sort"));
        assertTrue(output.contains("7) Counting sort"));
        assertTrue(output.contains("8) Shell sort"));
        assertTrue(output.contains("9) Comb sort"));
        assertTrue(output.contains("10) Cocktail sort"));
        assertTrue(output.contains("11) Gnome sort"));
        assertTrue(output.contains("12) Radix sort"));
        assertTrue(output.contains("13) Bitonic sort"));
        assertTrue(output.contains("14) Sort comparator"));
    }

    @Test
    void getNameShouldReturnSortAlgorithmsString() {
        assertEquals("Sort algorithms", sortAlgorithms.getName());
    }
}