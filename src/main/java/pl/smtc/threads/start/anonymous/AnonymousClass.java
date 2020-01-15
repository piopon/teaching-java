package pl.smtc.threads.start.anonymous;

import pl.smtc.menu.ConsoleExample;
import pl.smtc.menu.ConsoleScanner;

public class AnonymousClass implements ConsoleExample {
    private boolean threadInterrupt;
    private int threadCount;

    public AnonymousClass() {
        this.threadInterrupt = true;
        this.threadCount = 50;
    }

    public AnonymousClass(int threadCount, boolean threadInterrupt) {
        this.threadInterrupt = threadInterrupt;
        this.threadCount = threadCount;
    }

    @Override
    public void execute() {
        ConsoleScanner in = new ConsoleScanner(System.in);
        System.out.print("> press Enter to run second thread.");
        in.waitForInput();

        Thread testThread = new Thread(new Runnable() {
            @Override
            public void run() {
                threadMethod(1, threadCount, true);
            }
        });
        testThread.start();
        System.out.println("> second thread is running!");

        System.out.println("> press Enter to print message from main thread.");
        while (testThread.isAlive()) {
            if (threadInterrupt && in.waitForInput(100)) {
                System.out.println("> message from main thread!" + System.lineSeparator());
            }
        }
        System.out.println("> second thread has stopped!");
        System.out.print("> press Enter to go back to menu.");
        in.waitForInput();
    }

    @Override
    public String getName() {
        return "Anonymous class usage";
    }

    private void threadMethod(final int id, final int countLimit, final boolean showCounter) {
        System.out.println("TestThread " + id + " -> run [start]");
        for (int i = 0; i < countLimit; i++) {
            if (showCounter && i % 5 == 0) {
                System.out.println("TestThread " + id + " -> counter: " + i);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("TestThread " + id + " -> interrupt!");
            }
        }
        System.out.println("TestThread " + id + " -> run [stop]");
    }
}
