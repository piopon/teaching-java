package pl.smtc.basics.primitives.examples;

import pl.smtc.menu.ConsoleExample;
import pl.smtc.menu.ConsoleMenu;

import java.util.HashMap;
import java.util.Map;

public class PrimitivesExamples implements ConsoleExample {
    private Map<Integer, ConsoleExample> typesExamples = new HashMap<>();
    private int menuWidth = 35;

    @Override
    public void execute() {
        addExamples(new WeightConverter(), new KilobytesConverter());

        ConsoleMenu primitivesMenu = new ConsoleMenu(getName(), menuWidth, typesExamples);
        primitivesMenu.show();
    }

    @Override
    public String getName() {
        return "Examples";
    }

    private void addExamples(ConsoleExample... examples) {
        for(int i = 0; i < examples.length; i++) {
            typesExamples.put(i, examples[i]);
        }
    }
}
