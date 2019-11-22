package pl.smtc.basics;

import pl.smtc.basics.hello.HelloWorld;
import pl.smtc.basics.primitives.PrimitiveTypes;
import pl.smtc.basics.string.StringType;
import pl.smtc.menu.ConsoleExample;
import pl.smtc.menu.ConsoleMenu;

import java.util.HashMap;
import java.util.Map;

public class BasicsExamples implements ConsoleExample {
    private Map<Integer, ConsoleExample> basicsExamples = new HashMap<>();
    private int menuWidth = 35;

    @Override
    public void execute() {
        addExamples(new HelloWorld(), new PrimitiveTypes(), new StringType());

        ConsoleMenu basicsMenu = new ConsoleMenu(getName(), menuWidth, basicsExamples);
        basicsMenu.show();
    }

    @Override
    public String getName() {
        return "Basics examples";
    }

    private void addExamples(ConsoleExample... examples) {
        for(int i = 0; i < examples.length; i++) {
            basicsExamples.put(i, examples[i]);
        }
    }
}
