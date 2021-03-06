package pl.smtc.basics.string;

import pl.smtc.basics.string.checks.StringChecks;
import pl.smtc.basics.string.conversions.StringConversions;
import pl.smtc.basics.string.inspections.StringInspections;
import pl.smtc.basics.string.transformations.StringTransformations;
import pl.smtc.menu.ConsoleExample;
import pl.smtc.menu.ConsoleMenu;

import java.util.HashMap;
import java.util.Map;

public class StringType implements ConsoleExample {
    private Map<Integer, ConsoleExample> stringExamples = new HashMap<>();
    private int menuWidth = 35;

    @Override
    public void execute() {
        addExamples(new StringChecks(), new StringConversions(),
                    new StringInspections(), new StringTransformations());

        ConsoleMenu stringMenu = new ConsoleMenu(getName(), menuWidth, stringExamples);
        stringMenu.show();
    }

    @Override
    public String getName() {
        return "String type";
    }

    private void addExamples(ConsoleExample... examples) {
        for(int i = 0; i < examples.length; i++) {
            stringExamples.put(i, examples[i]);
        }
    }
}
