package pl.smtc.algorithms.sort.bubble;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.smtc.base.BaseTestOut;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest extends BaseTestOut {
    private BubbleSort bubbleSort;

    @Override
    protected void setUp() {
        bubbleSort = new BubbleSort();
    }

    @Test
    void executeShouldInvokeBubbleSortExample() {
        bubbleSort.execute();
        String output = getOutput();
        assertTrue(output.contains("TO SORT: [10, -9, 1, 0, -1, 4, 3, -3, 1, 2]"));
        assertTrue(output.contains("NORMAL = [-9, -3, -1, 0, 1, 1, 2, 3, 4, 10] -> 10 scans"));
        assertTrue(output.contains("FAST   = [-9, -3, -1, 0, 1, 1, 2, 3, 4, 10] -> 6 scans"));
    }

    @Test
    void getNameShouldReturnBubbleSortString() {
        assertEquals("Bubble sort", bubbleSort.getName());
    }

    @ParameterizedTest(name = "Bubble sorted array: {1}")
    @MethodSource("sortTestData")
    void sortShouldCorrectlySortInputTable(List<Integer> toSort, List<Integer> sorted) {
        assertEquals(sorted, bubbleSort.sort(toSort));
    }

    private static Stream<Arguments> sortTestData() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 1, 1, 1, 1, 1), Arrays.asList(1, 1, 1, 1, 1, 1)),
            Arguments.of(Arrays.asList(1, 2, -1, -2, 0), Arrays.asList(-2, -1, 0, 1, 2)),
            Arguments.of(Arrays.asList(0, 1, 2, 3, 4), Arrays.asList(0, 1, 2, 3, 4)),
            Arguments.of(Arrays.asList(-5, -4, -3, -2, -1), Arrays.asList(-5, -4, -3, -2, -1)),
            Arguments.of(Arrays.asList(-100, 100, 1, -5, -1), Arrays.asList(-100, -5, -1, 1, 100)),
            Arguments.of(Arrays.asList(-3, -3, 7, 7, 0, 0), Arrays.asList(-3, -3, 0, 0, 7, 7)),
            Arguments.of(Arrays.asList(-1, -1, -1, -1, -1, -1), Arrays.asList(-1, -1, -1, -1, -1, -1)),
            Arguments.of(Arrays.asList(0, 0, 0, -1, 1), Arrays.asList(-1, 0, 0, 0, 1)));
    }
}