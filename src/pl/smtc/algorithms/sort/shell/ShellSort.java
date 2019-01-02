package pl.smtc.algorithms.sort.shell;

import pl.smtc.algorithms.sort.comparator.SortExample;
import pl.smtc.menu.ConsoleExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShellSort implements ConsoleExample, SortExample {

    @Override
    public void execute() {
        List<Integer> toSort = Arrays.asList(10, -9, 1, 0, -1, 4, 3, -3, 1, 2);
        System.out.println("TO SORT: " + toSort);
        System.out.println("SORTED:  " + sort(toSort));
    }

    @Override
    public String getName() {
        return "Shell sort";
    }

    public List<Integer> sort(final List<Integer> input) {
        List<Integer> result = new ArrayList<>(input);

        for (int gap = input.size()/2; gap > 0; gap /= 2) {
            for (int i = gap; i < input.size(); i += 1) {
                int temp = result.get(i), j;
                for (j = i; j >= gap && result.get(j - gap) > temp; j -= gap) {
                    result.set(j, result.get(j - gap));
                }
                result.set(j, temp);
            }
        }
        return result;
    }
}
