package pl.smtc.threads;

import pl.smtc.menu.ConsoleExample;
import pl.smtc.menu.ConsoleMenu;
import pl.smtc.threads.comm.ThreadsCommunication;
import pl.smtc.threads.start.StartingThreads;
import pl.smtc.threads.stop.StoppingThreads;
import pl.smtc.threads.sync.SynchronizingThreads;

import java.util.HashMap;
import java.util.Map;

public class ConcurrencyExamples implements ConsoleExample {
    private Map<Integer, ConsoleExample> concurrencyExamples = new HashMap<>();
    private int menuWidth = 35;

    @Override
    public void execute() {
        addExamples(new StartingThreads(), new StoppingThreads(), new ThreadsCommunication(),
                    new SynchronizingThreads());

        ConsoleMenu concurrencyMenu = new ConsoleMenu(getName(), menuWidth, concurrencyExamples);
        concurrencyMenu.show();
    }

    @Override
    public String getName() {
        return "Concurrency examples";
    }

    private void addExamples(ConsoleExample... exercises) {
        for(int i = 0; i < exercises.length; i++) {
            concurrencyExamples.put(i, exercises[i]);
        }
    }
}
