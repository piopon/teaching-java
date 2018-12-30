package pl.smtc.algorithms.sort.selection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.smtc.base.BaseTestOut;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest extends BaseTestOut {
    private SelectionSort selectionSort;

    @Override
    protected void setUp() {
        selectionSort = new SelectionSort();
    }

    @Test
    void executeShouldInvokeSelectionSortExample() {
        selectionSort.execute();
        String output = getOutput();
        assertTrue(output.contains("TO SORT: [10, -9, 1, 0, -1, 4, 3, -3, 1, 2]"));
        assertTrue(output.contains("SORTED:  [-9, -3, -1, 0, 1, 1, 2, 3, 4, 10]"));
    }

    @Test
    void getNameShouldReturnSelectionSortString() {
        assertEquals("Selection sort", selectionSort.getName());
    }

    @ParameterizedTest(name = "Selection sorted array: {1}")
    @MethodSource("sortTestData")
    void sortShouldCorrectlySortInputTable(List<Integer> toSort, List<Integer> sorted) {
        assertEquals(sorted, selectionSort.sort(toSort));
    }

    private static Stream<Arguments> sortTestData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 1, 1, 1, 1, 1), Arrays.asList(1, 1, 1, 1, 1, 1)),
                Arguments.of(Arrays.asList(-37, 22, -11, -27, 0), Arrays.asList(-37, -27, -11, 0, 22)),
                Arguments.of(Arrays.asList(30, 41, 52, 63, 74), Arrays.asList(30, 41, 52, 63, 74)),
                Arguments.of(Arrays.asList(-45, -44, -33, -12, -11), Arrays.asList(-45, -44, -33, -12, -11)),
                Arguments.of(Arrays.asList(-51, 51, 15, -52, -15), Arrays.asList(-52, -51, -15, 15, 51)),
                Arguments.of(Arrays.asList(-37, -37, 73, 73, 0, 0), Arrays.asList(-37, -37, 0, 0, 73, 73)),
                Arguments.of(Arrays.asList(-11, -11, -11, -11, -11, -11), Arrays.asList(-11, -11, -11, -11, -11, -11)),
                Arguments.of(Arrays.asList(0, 0, 0, -7, 7), Arrays.asList(-7, 0, 0, 0, 7)));
    }
}