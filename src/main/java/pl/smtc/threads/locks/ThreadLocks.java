package pl.smtc.threads.locks;

import pl.smtc.menu.ConsoleExample;
import pl.smtc.menu.ConsoleMenu;
import pl.smtc.threads.locks.fair.FairLock;
import pl.smtc.threads.locks.optimistic.OptimisticLock;
import pl.smtc.threads.locks.read_write.ReadWriteExample;
import pl.smtc.threads.locks.reentrant.ReentrantExample;
import pl.smtc.threads.locks.simple.SimpleLock;
import pl.smtc.threads.locks.stamped.StampedExample;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocks implements ConsoleExample {
    private Map<Integer, ConsoleExample> locksExamples = new HashMap<>();
    private int menuWidth = 35;

    @Override
    public void execute() {
        addExamples(new SimpleLock(), new ReentrantExample(), new FairLock(),
                    new ReadWriteExample(), new StampedExample(), new OptimisticLock());

        ConsoleMenu locksMenu = new ConsoleMenu(getName(), menuWidth, locksExamples);
        locksMenu.show();
    }

    @Override
    public String getName() {
        return "Threads locks";
    }

    private void addExamples(ConsoleExample... exercises) {
        for (int i = 0; i < exercises.length; i++) {
            locksExamples.put(i, exercises[i]);
        }
    }
}
