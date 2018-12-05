package pl.smtc.threads.locks.fair;

import pl.smtc.menu.ConsoleExample;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairLock implements ConsoleExample {
    private Lock lock = new ReentrantLock(true);
    private int maxCount;

    public FairLock() {
        maxCount = 500;
    }

    public FairLock(int maxCount) {
        this.maxCount = maxCount;
    }

    @Override
    public void execute() {
        try {
            Thread thread01 = createThread("Thread priority 1", 1);
            Thread thread09 = createThread("Thread priority 6", 6);
            Thread thread10 = createThread("Thread priority 10", 10);

            thread01.start();
            thread09.start();
            thread10.start();

            thread01.join();
            thread09.join();
            thread10.join();
        } catch (InterruptedException e) {
            System.out.println("> " + getName().toLowerCase() + " example interrupt!");
        }
    }

    @Override
    public String getName() {
        return "Fair lock example";
    }

    private Thread createThread(String name, int priority) {
        Thread result = new Thread(new WorkerThread(lock, name, maxCount));
        result.setPriority(priority);

        return result;
    }

}
