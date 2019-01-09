package pl.smtc.algorithms.search.comparator;

import pl.smtc.algorithms.sort.counting.CountingSort;
import pl.smtc.menu.ConsoleExample;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SearchComparator implements ConsoleExample {
    private List<SearchExample> searchAlgorithms;
    private static final int MIN_INT = -1000;
    private static final int MAX_INT = 1000;
    private static final int LIST_SIZE = 5000;

    public SearchComparator(final List<SearchExample> searchAlgorithms) {
        this.searchAlgorithms = searchAlgorithms;
    }

    @Override
    public void execute() {
        System.out.println("SEARCH COMPARATOR (test list size: " + LIST_SIZE + ")");
        List<Integer> testInput = generateRandomList(LIST_SIZE);
        int indexToFind = getRandomInt(0, LIST_SIZE-1);
        int elementToFind = testInput.get(indexToFind);
        System.out.println("ELEMENT TO FIND: " + elementToFind + " (index: " + indexToFind + ")");
        for(SearchExample example : searchAlgorithms) {
            long timeElapsed = measureSortTime(example, testInput, elementToFind);
            System.out.println(generateSummary(example.getName(), timeElapsed));
        }
    }

    @Override
    public String getName() {
        return "Search comparator";
    }

    private long measureSortTime(SearchExample example, List<Integer> input, int elementToFind) {
        long startTime = System.nanoTime();
        example.find(input, elementToFind);

        return System.nanoTime() - startTime;
    }

    private String generateSummary(String testName, long sortTime) {
        return "  - " + testName + getIndent(testName.length()) + sortTime + "[ns]";
    }

    private List<Integer> generateRandomList(int size) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(getRandomInt(MIN_INT, MAX_INT));
        }
        return new CountingSort().sort(result);
    }

    private int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max + 1 - min) + min;
    }

    private String getIndent(int nameLength) {
        if (nameLength < 14) {
            return nameLength < 12 ? "\t\t\t\t" : "\t\t\t";
        } else {
            return nameLength > 20 ? "\t" : "\t\t";
        }
    }
}
