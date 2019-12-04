package pl.smtc.basics.string.transformations;

import pl.smtc.menu.ConsoleExample;
import pl.smtc.menu.ConsoleMenu;

import java.util.HashMap;
import java.util.Map;

public class StringTransformations implements ConsoleExample {
    private Map<Integer, ConsoleExample> stringTransformations = new HashMap<>();
    private int menuWidth = 35;

    @Override
    public void execute() {
        addExamples(new StringBasic(), new StringReplace(), new StringSplit());

        ConsoleMenu stringMenu = new ConsoleMenu(getName(), menuWidth, stringTransformations);
        stringMenu.show();
    }

    @Override
    public String getName() {
        return "String transformations";
    }

    private void addExamples(ConsoleExample... examples) {
        for(int i = 0; i < examples.length; i++) {
            stringTransformations.put(i, examples[i]);
        }
    }
}
