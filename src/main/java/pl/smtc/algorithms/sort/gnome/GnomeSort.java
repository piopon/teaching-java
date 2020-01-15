package pl.smtc.algorithms.sort.gnome;

import pl.smtc.algorithms.sort.comparator.SortExample;
import pl.smtc.menu.ConsoleExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GnomeSort implements ConsoleExample, SortExample {

    @Override
    public void execute() {
        List<Integer> toSort = Arrays.asList(10, -9, 1, 0, -1, 4, 3, -3, 1, 2);
        System.out.println("TO SORT: " + toSort);
        System.out.println("SORTED:  " + sort(toSort));
    }

    @Override
    public String getName() {
        return "Gnome sort";
    }

    public List<Integer> sort(final List<Integer> input) {
        List<Integer> result = new ArrayList<>(input);

        if(result.size() == 1) {
            return result;
        }

        int index = 0;
        while (index < result.size()) {
            if (index == 0) {
                index++;
            }
            if (result.get(index) >= result.get(index - 1)) {
                index++;
            } else {
                swap(result, index, index-1);
                index--;
            }
        }
        return result;
    }

    private void swap(List<Integer> list, int firstIndex, int secondIndex) {
        int temp = list.get(firstIndex);
        list.set(firstIndex, list.get(secondIndex));
        list.set(secondIndex, temp);
    }
}
