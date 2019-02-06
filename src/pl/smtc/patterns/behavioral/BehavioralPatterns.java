package pl.smtc.patterns.behavioral;

import pl.smtc.menu.ConsoleExample;
import pl.smtc.menu.ConsoleMenu;
import pl.smtc.patterns.behavioral.command.CommandPattern;

import java.util.HashMap;
import java.util.Map;

public class BehavioralPatterns implements ConsoleExample {
    private Map<Integer, ConsoleExample> behavioralExamples = new HashMap<>();
    private int menuWidth = 35;

    @Override
    public void execute() {
        addExamples(new CommandPattern());

        ConsoleMenu behavioralMenu = new ConsoleMenu(getName(), menuWidth, behavioralExamples);
        behavioralMenu.show();
    }

    @Override
    public String getName() {
        return "Behavioral patterns";
    }

    private void addExamples(ConsoleExample... examples) {
        for(int i = 0; i < examples.length; i++) {
            behavioralExamples.put(i, examples[i]);
        }
    }
}
