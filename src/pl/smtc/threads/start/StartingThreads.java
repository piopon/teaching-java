package pl.smtc.threads.start;

import pl.smtc.menu.ConsoleExample;
import pl.smtc.menu.ConsoleMenu;
import pl.smtc.threads.start.anonymous.AnonymousClass;
import pl.smtc.threads.start.executors.UseExecutors;
import pl.smtc.threads.start.extend.ExtendThread;
import pl.smtc.threads.start.implement.ImplementRunnable;
import pl.smtc.threads.start.lambda.Lambda;

import java.util.HashMap;
import java.util.Map;

public class StartingThreads implements ConsoleExample {
    private Map<Integer, ConsoleExample> startThreadsExamples = new HashMap<>();
    private int menuWidth = 35;

    @Override
    public void execute() {
        addExamples(new ExtendThread(), new ImplementRunnable(), new AnonymousClass(),
                    new Lambda(), new UseExecutors());

        ConsoleMenu startThreadsMenu = new ConsoleMenu(getName(), menuWidth, startThreadsExamples);
        startThreadsMenu.show();
    }

    @Override
    public String getName() {
        return "Start threads";
    }

    private void addExamples(ConsoleExample... exercises) {
        for(int i = 0; i < exercises.length; i++) {
            startThreadsExamples.put(i, exercises[i]);
        }
    }
}
