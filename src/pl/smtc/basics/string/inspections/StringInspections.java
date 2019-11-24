package pl.smtc.basics.string.inspections;

import pl.smtc.menu.ConsoleExample;
import pl.smtc.menu.ConsoleMenu;

import java.util.HashMap;
import java.util.Map;

public class StringInspections implements ConsoleExample {
    private Map<Integer, ConsoleExample> stringInspections = new HashMap<>();
    private int menuWidth = 35;

    @Override
    public void execute() {
        addExamples(new StringBasic());

        ConsoleMenu inspectionsMenu = new ConsoleMenu(getName(), menuWidth, stringInspections);
        inspectionsMenu.show();
    }

    @Override
    public String getName() {
        return "String inspections";
    }

    private void addExamples(ConsoleExample... examples) {
        for(int i = 0; i < examples.length; i++) {
            stringInspections.put(i, examples[i]);
        }
    }
}
