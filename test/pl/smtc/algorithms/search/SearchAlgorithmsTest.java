package pl.smtc.algorithms.search;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class SearchAlgorithmsTest extends BaseTestInOut {
    private SearchAlgorithms searchAlgorithms;

    @Override
    protected void setUp() {
        searchAlgorithms = new SearchAlgorithms();
    }

    @Test
    void executeShouldInvokeSearchAlgorithmsMenu() {
        simulateUserInput("0");
        searchAlgorithms.execute();
        String output = getOutput();
        assertTrue(output.contains("SEARCH ALGORITHMS"));
        assertTrue(output.contains("1) Linear search"));
        assertTrue(output.contains("2) Binary search"));
    }

    @Test
    void getNameShouldReturnSearchAlgorithmsString() {
        assertEquals("Search algorithms", searchAlgorithms.getName());
    }
}