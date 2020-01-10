package pl.smtc.algorithms.search.comparator;

import org.junit.jupiter.api.Test;
import pl.smtc.algorithms.sort.comparator.SortExample;
import pl.smtc.base.BaseTestOut;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class SearchComparatorTest extends BaseTestOut {
    private SearchComparator searchComparator;

    @Override
    protected void setUp() {
        searchComparator = new SearchComparator(Arrays.asList(createSearchExample("Test7"),
                createSearchExample("Test21"), createSearchExample("Test13")));
    }

    @Test
    void executeShouldInvokeSearchComparatorExample() {
        searchComparator.execute();
        String output = getOutput();
        assertTrue(output.contains("SEARCH COMPARATOR (test list size: 5000)"));
        assertTrue(output.contains("ELEMENT TO FIND:"));
        assertTrue(output.contains("  - Test7"));
        assertTrue(output.contains("  - Test21"));
        assertTrue(output.contains("  - Test13"));
    }

    @Test
    void getNameShouldReturnSearchComparatorString() {
        assertEquals("Search comparator", searchComparator.getName());
    }

    private SearchExample createSearchExample(String exampleName) {
        return new SearchExample() {
            @Override
            public int find(List<Integer> list, int elementToFind) throws NoSuchElementException {
                return 0;
            }

            @Override
            public String getName() {
                return exampleName;
            }
        };
    }


}