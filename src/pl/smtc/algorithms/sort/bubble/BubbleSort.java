package pl.smtc.algorithms.sort.bubble;

import pl.smtc.menu.ConsoleExample;

import java.util.Arrays;
import java.util.List;

public class BubbleSort implements ConsoleExample {

    @Override
    public void execute() {
        List<Integer> toSort = Arrays.asList(10, -9, 1, 0, -1, 4, 3, -3, 2, 1);
        System.out.println("TO SORT: " + toSort);
        List<Integer> sorted = sort(toSort);
        System.out.println("SORTED: " + sorted);
    }

    @Override
    public String getName() {
        return "Bubble sort";
    }

    public List<Integer> sort(List<Integer> input) {
        List<Integer> result = input;
        for (int i = 0; i < input.size(); i++) {
            for (int j = 0; j < input.size() - i - 1; j++) {
                if(result.get(j) > result.get(j+1)) {
                    int temp = result.get(j);
                    result.set(j, result.get(j+1));
                    result.set(j+1, temp);
                }
            }
        }
        return result;
    }
}
