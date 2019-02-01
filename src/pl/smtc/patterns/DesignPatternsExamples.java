package pl.smtc.patterns;

import pl.smtc.menu.ConsoleExample;
import pl.smtc.menu.ConsoleMenu;

import java.util.HashMap;
import java.util.Map;

public class DesignPatternsExamples implements ConsoleExample {
    private Map<Integer, ConsoleExample> patternsExamples = new HashMap<>();
    private int menuWidth = 35;

    @Override
    public void execute() {
        addExamples();

        ConsoleMenu patternsMenu = new ConsoleMenu(getName(), menuWidth, patternsExamples);
        patternsMenu.show();
    }

    @Override
    public String getName() {
        return "Design patterns";
    }

    private void addExamples(ConsoleExample... examples) {
        for(int i = 0; i < examples.length; i++) {
            patternsExamples.put(i, examples[i]);
        }
    }
}
