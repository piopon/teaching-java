package pl.smtc.threads.issues.starvation;

import javafx.concurrent.Worker;
import pl.smtc.menu.ConsoleExample;

public class ThreadsStarvation implements ConsoleExample {
    private static Object lock = new Object();

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
        return "Thread starvation";
    }

    private Thread createThread(String name, int priority) {
        Thread result = new Thread(new WorkerThread(name, 500, lock));
        result.setPriority(priority);

        return result;
    }
}
