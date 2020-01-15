package pl.smtc.algorithms.sort.comparator;

import pl.smtc.menu.ConsoleExample;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SortComparator implements ConsoleExample {
    private List<SortExample> sortAlgorithms;
    private static final int MIN_INT = -1000;
    private static final int MAX_INT = 1000;
    private static final int LIST_SIZE = 5000;

    public SortComparator(final List<SortExample> sortAlgorithms) {
        this.sortAlgorithms = sortAlgorithms;
    }

    @Override
    public void execute() {
        System.out.println("SORT COMPARATOR (test list size: " + LIST_SIZE + ")");
        List<Integer> testInput = generateRandomList(LIST_SIZE);
        for (SortExample example : sortAlgorithms) {
            long timeElapsed = measureSortTime(example, testInput);
            System.out.println(generateSummary(example.getName(), timeElapsed));
        }
    }

    @Override
    public String getName() {
        return "Sort comparator";
    }

    private long measureSortTime(SortExample example, List<Integer> input) {
        long startTime = System.nanoTime();
        example.sort(input);

        return System.nanoTime() - startTime;
    }

    private String generateSummary(String testName, long sortTime) {
        String indent = testName.length() > 11 ? "\t" : "\t\t";

        return "  - " + testName + indent + TimeUnit.NANOSECONDS.toMillis(sortTime) + "[ms]";
    }

    private List<Integer> generateRandomList(int size) {
        List<Integer> result = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            result.add(random.nextInt(MAX_INT + 1 - MIN_INT) + MIN_INT);
        }
        return result;
    }
}
