package pl.smtc.threads.sync;

import pl.smtc.menu.ConsoleExample;
import pl.smtc.menu.ConsoleMenu;
import pl.smtc.threads.sync.block.SyncBlock;
import pl.smtc.threads.sync.join.JoiningThreads;
import pl.smtc.threads.sync.latch.CountdownLatch;
import pl.smtc.threads.sync.method.SyncMethod;
import pl.smtc.threads.sync.semaphore.SemaphoreSync;
import pl.smtc.threads.sync.wait_notify.WaitNotify;

import java.util.HashMap;
import java.util.Map;

public class SynchronizingThreads implements ConsoleExample {
    private Map<Integer, ConsoleExample> syncThreadsExamples = new HashMap<>();
    int menuWidth = 35;

    @Override
    public void execute() {
        addExamples(new SyncMethod(), new SyncBlock(), new JoiningThreads(),
                    new CountdownLatch(), new SemaphoreSync(), new WaitNotify());

        ConsoleMenu syncThreadsMenu = new ConsoleMenu(getName(), menuWidth, syncThreadsExamples);
        syncThreadsMenu.show();
    }

    @Override
    public String getName() {
        return "Synchronizing threads";
    }

    private void addExamples(ConsoleExample... exercises) {
        for (int i = 0; i < exercises.length; i++) {
            syncThreadsExamples.put(i, exercises[i]);
        }
    }
}
