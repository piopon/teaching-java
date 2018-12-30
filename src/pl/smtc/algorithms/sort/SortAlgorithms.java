package pl.smtc.algorithms.sort;

import pl.smtc.algorithms.sort.bubble.BubbleSort;
import pl.smtc.algorithms.sort.comb.CombSort;
import pl.smtc.algorithms.sort.counting.CountingSort;
import pl.smtc.algorithms.sort.heap.HeapSort;
import pl.smtc.algorithms.sort.insertion.InsertionSort;
import pl.smtc.algorithms.sort.merge.MergeSort;
import pl.smtc.algorithms.sort.quick.QuickSort;
import pl.smtc.algorithms.sort.selection.SelectionSort;
import pl.smtc.algorithms.sort.shell.ShellSort;
import pl.smtc.menu.ConsoleExample;
import pl.smtc.menu.ConsoleMenu;

import java.util.HashMap;
import java.util.Map;

public class SortAlgorithms implements ConsoleExample {
    private Map<Integer, ConsoleExample> sortAlgorithms = new HashMap<>();
    private int menuWidth = 35;

    @Override
    public void execute() {
        addExamples(new BubbleSort(), new InsertionSort(), new QuickSort(), new SelectionSort(),
                    new MergeSort(), new HeapSort(), new CountingSort(), new ShellSort(),
                    new CombSort());

        ConsoleMenu sortAlgorithmsMenu = new ConsoleMenu(getName(), menuWidth, sortAlgorithms);
        sortAlgorithmsMenu.show();
    }

    @Override
    public String getName() {
        return "Sort algorithms";
    }

    private void addExamples(ConsoleExample... examples) {
        for (int i = 0; i < examples.length; i++) {
            sortAlgorithms.put(i, examples[i]);
        }
    }
}
