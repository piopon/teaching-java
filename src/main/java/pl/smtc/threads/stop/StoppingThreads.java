package pl.smtc.threads.stop;

import pl.smtc.menu.ConsoleExample;
import pl.smtc.menu.ConsoleMenu;
import pl.smtc.threads.stop.interrupt.InterruptStop;
import pl.smtc.threads.stop.variable.BasicStop;

import java.util.HashMap;
import java.util.Map;

public class StoppingThreads implements ConsoleExample {
    private Map<Integer, ConsoleExample> stopExamples = new HashMap<>();
    private int menuWidth = 35;

    @Override
    public void execute() {
        addExamples(new BasicStop(), new InterruptStop());

        ConsoleMenu stopMenu = new ConsoleMenu(getName(), menuWidth, stopExamples);
        stopMenu.show();
    }

    @Override
    public String getName() {
        return "Stopping threads";
    }

    private void addExamples(ConsoleExample... exercises) {
        for (int i = 0; i < exercises.length; i++) {
            stopExamples.put(i, exercises[i]);
        }
    }
}
