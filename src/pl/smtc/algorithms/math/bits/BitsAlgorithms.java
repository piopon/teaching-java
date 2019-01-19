package pl.smtc.algorithms.math.bits;

import pl.smtc.menu.ConsoleExample;
import pl.smtc.menu.ConsoleMenu;

import java.util.HashMap;
import java.util.Map;

public class BitsAlgorithms implements ConsoleExample {
    private Map<Integer, ConsoleExample> bitsAlgorithms = new HashMap<>();
    private int menuWidth = 35;

    @Override
    public void execute() {
        addExamples();

        ConsoleMenu bitsAlgorithmsMenu = new ConsoleMenu(getName(), menuWidth, bitsAlgorithms);
        bitsAlgorithmsMenu.show();
    }

    @Override
    public String getName() {
        return "Bits algorithms";
    }

    private void addExamples(ConsoleExample... examples) {
        for (int i = 0; i < examples.length; i++) {
            bitsAlgorithms.put(i, examples[i]);
        }
    }
}
