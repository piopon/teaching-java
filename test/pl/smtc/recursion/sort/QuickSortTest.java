package pl.smtc.recursion.sort;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {
    private QuickSort quickSort;
    private static final ByteArrayOutputStream OUTPUT_STREAM = new ByteArrayOutputStream();

    @BeforeEach
    void setup() {
        quickSort = new QuickSort();
        System.setOut(new PrintStream(OUTPUT_STREAM));
    }

    @AfterEach
    void teardown() {
        System.setOut(System.out);
    }

    @Test
    void executeShouldOutputBothInputAndSortedTable() {
        quickSort.execute();
        String output = OUTPUT_STREAM.toString();
        assertTrue(output.contains("TO SORT: [23, 31, 1, 21, 36, 72, 100, -10, 0, 23]"));
        assertTrue(output.contains("RESULT:  [-10, 0, 1, 21, 23, 23, 31, 36, 72, 100]"));
    }

    @Test
    void getNameShouldReturnQuickSort() {
        assertEquals("Quick sort", quickSort.getName());
    }

    @ParameterizedTest(name = "{0} -> sorted: {1}")
    @MethodSource("sortArraysTestData")
    void sortReturnsCorrectArray(int[] input, int[] expected) {
        assertArrayEquals(expected, quickSort.sort(input, 0, input.length - 1));
    }

    private static Stream<Arguments> sortArraysTestData() {
        return Stream.of(
                Arguments.of(new int[]{1}, new int[]{1}),
                Arguments.of(new int[]{1, 2}, new int[]{1, 2}),
                Arguments.of(new int[]{-1, 1, 0}, new int[]{-1, 0, 1}),
                Arguments.of(new int[]{22, 5, 35, 2}, new int[]{2, 5, 22, 35}),
                Arguments.of(new int[]{-1, -25, -10}, new int[]{-25, -10, -1}),
                Arguments.of(new int[]{-1, 0, -1, -2, 5}, new int[]{-2, -1, -1, 0, 5}),
                Arguments.of(new int[]{11, -11, 1, -1, -5, 6}, new int[]{-11, -5, -1, 1, 6, 11}),
                Arguments.of(new int[]{-100, 31, 0, 0, 31, -100}, new int[]{-100, -100, 0, 0, 31, 31}),
                Arguments.of(new int[]{67, 12, -82, 43, 99, 82, -111}, new int[]{-111, -82, 12, 43, 67, 82, 99}));
    }
}