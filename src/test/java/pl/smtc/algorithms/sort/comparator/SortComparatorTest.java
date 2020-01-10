package pl.smtc.algorithms.sort.comparator;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortComparatorTest extends BaseTestOut {
    private SortComparator sortComparator;


    @Override
    protected void setUp() {
        sortComparator = new SortComparator(Arrays.asList(createSortExample("Test1"),
                createSortExample("Test2"), createSortExample("Test3")));
    }

    @Test
    void executeShouldInvokeSortComparatorExample() {
        sortComparator.execute();
        String output = getOutput();
        assertTrue(output.contains("SORT COMPARATOR (test list size: 5000)"));
        assertTrue(output.contains("  - Test1"));
        assertTrue(output.contains("  - Test2"));
        assertTrue(output.contains("  - Test3"));
    }

    @Test
    void getNameShouldReturnSortComparatorString() {
        assertEquals("Sort comparator", sortComparator.getName());
    }

    private SortExample createSortExample(String exampleName) {
        return new SortExample() {
            @Override
            public List<Integer> sort(List<Integer> input) {
                return input;
            }

            @Override
            public String getName() {
                return exampleName;
            }
        };
    }
}