package pl.smtc.algorithms.sort.gnome;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.smtc.base.BaseTestOut;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GnomeSortTest extends BaseTestOut {
    private GnomeSort gnomeSort;

    @Override
    protected void setUp() {
        gnomeSort = new GnomeSort();
    }

    @Test
    void executeShouldInvokeGnomeSortExample() {
        gnomeSort.execute();
        String output = getOutput();
        assertTrue(output.contains("TO SORT: [10, -9, 1, 0, -1, 4, 3, -3, 1, 2]"));
        assertTrue(output.contains("SORTED:  [-9, -3, -1, 0, 1, 1, 2, 3, 4, 10]"));
    }

    @Test
    void getNameShouldReturnGnomeSortString() {
        assertEquals("Gnome sort", gnomeSort.getName());
    }

    @ParameterizedTest(name = "Gnome sorted array: {1}")
    @MethodSource("sortTestData")
    void sortShouldCorrectlySortInputTable(List<Integer> toSort, List<Integer> sorted) {
        assertEquals(sorted, gnomeSort.sort(toSort));
    }

    private static Stream<Arguments> sortTestData() {
        return Stream.of(
                Arguments.of(Arrays.asList(17), Arrays.asList(17)),
                Arguments.of(Arrays.asList(6, 66), Arrays.asList(6, 66)),
                Arguments.of(Arrays.asList(2, 1), Arrays.asList(1, 2)),
                Arguments.of(Arrays.asList(-12, 0, -11), Arrays.asList(-12, -11, 0)),
                Arguments.of(Arrays.asList(-122, -1, 34), Arrays.asList(-122, -1, 34)),
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