package pl.smtc.patterns.structural;

import pl.smtc.menu.ConsoleExample;
import pl.smtc.menu.ConsoleMenu;
import pl.smtc.patterns.structural.adapter.AdapterPattern;
import pl.smtc.patterns.structural.decorator.DecoratorPattern;
import pl.smtc.patterns.structural.facade.FacadePattern;
import pl.smtc.patterns.structural.proxy.ProxyPattern;

import java.util.HashMap;
import java.util.Map;

public class StructuralPatterns implements ConsoleExample {
    private Map<Integer, ConsoleExample> structuralExamples = new HashMap<>();
    private int menuWidth = 35;

    @Override
    public void execute() {
        addExamples(new DecoratorPattern(), new AdapterPattern(), new FacadePattern(),
                    new ProxyPattern());

        ConsoleMenu creationalMenu = new ConsoleMenu(getName(), menuWidth, structuralExamples);
        creationalMenu.show();
    }

    @Override
    public String getName() {
        return "Structural patterns";
    }

    private void addExamples(ConsoleExample... examples) {
        for(int i = 0; i < examples.length; i++) {
            structuralExamples.put(i, examples[i]);
        }
    }
}
