package pl.smtc.patterns.creational;

import pl.smtc.menu.ConsoleExample;
import pl.smtc.menu.ConsoleMenu;
import pl.smtc.patterns.creational.AbstractFactory.AbstractFactory;
import pl.smtc.patterns.creational.FactoryMethod.FactoryMethod;
import pl.smtc.patterns.creational.SimpleFactory.SimpleFactory;
import pl.smtc.patterns.creational.singleton.Singleton;

import java.util.HashMap;
import java.util.Map;

public class CreationalPatterns implements ConsoleExample {
    private Map<Integer, ConsoleExample> creationalExamples = new HashMap<>();
    private int menuWidth = 35;

    @Override
    public void execute() {
        addExamples(new SimpleFactory(), new FactoryMethod(), new AbstractFactory(),
                    new Singleton());

        ConsoleMenu creationalMenu = new ConsoleMenu(getName(), menuWidth, creationalExamples);
        creationalMenu.show();
    }

    @Override
    public String getName() {
        return "Creational patterns";
    }

    private void addExamples(ConsoleExample... examples) {
        for(int i = 0; i < examples.length; i++) {
            creationalExamples.put(i, examples[i]);
        }
    }
}
