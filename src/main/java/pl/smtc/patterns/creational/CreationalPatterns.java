package pl.smtc.patterns.creational;

import pl.smtc.menu.ConsoleExample;
import pl.smtc.menu.ConsoleMenu;
import pl.smtc.patterns.creational.factory.abstrakt.AbstractFactoryPattern;
import pl.smtc.patterns.creational.factory.method.FactoryMethodPattern;
import pl.smtc.patterns.creational.factory.simple.SimpleFactoryPattern;
import pl.smtc.patterns.creational.builder.BuilderPattern;
import pl.smtc.patterns.creational.singleton.SingletonPattern;

import java.util.HashMap;
import java.util.Map;

public class CreationalPatterns implements ConsoleExample {
    private Map<Integer, ConsoleExample> creationalExamples = new HashMap<>();
    private int menuWidth = 35;

    @Override
    public void execute() {
        addExamples(new SimpleFactoryPattern(), new FactoryMethodPattern(), new AbstractFactoryPattern(),
                    new SingletonPattern(), new BuilderPattern());

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
