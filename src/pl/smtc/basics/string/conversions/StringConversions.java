package pl.smtc.basics.string.conversions;

import pl.smtc.menu.ConsoleExample;
import pl.smtc.menu.ConsoleMenu;

import java.util.HashMap;
import java.util.Map;

public class StringConversions implements ConsoleExample {
    private Map<Integer, ConsoleExample> stringConversions = new HashMap<>();
    private int menuWidth = 35;

    @Override
    public void execute() {
        addExamples(new StringFromBool());

        ConsoleMenu conversionsMenu = new ConsoleMenu(getName(), menuWidth, stringConversions);
        conversionsMenu.show();
    }

    @Override
    public String getName() {
        return "String conversions";
    }

    private void addExamples(ConsoleExample... examples) {
        for(int i = 0; i < examples.length; i++) {
            stringConversions.put(i, examples[i]);
        }
    }
}
