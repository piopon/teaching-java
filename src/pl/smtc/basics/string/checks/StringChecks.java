package pl.smtc.basics.string.checks;

import pl.smtc.menu.ConsoleExample;
import pl.smtc.menu.ConsoleMenu;

import java.util.HashMap;
import java.util.Map;

public class StringChecks implements ConsoleExample {
    private Map<Integer, ConsoleExample> stringChecks = new HashMap<>();
    private int menuWidth = 35;

    @Override
    public void execute() {
        addExamples(new StringBounds(), new StringContents());

        ConsoleMenu checksMenu = new ConsoleMenu(getName(), menuWidth, stringChecks);
        checksMenu.show();
    }

    @Override
    public String getName() {
        return "String checks";
    }

    private void addExamples(ConsoleExample... examples) {
        for(int i = 0; i < examples.length; i++) {
            stringChecks.put(i, examples[i]);
        }
    }
}
