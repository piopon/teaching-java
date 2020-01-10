package pl.smtc.threads.start.extend;

import pl.smtc.menu.ConsoleExample;
import pl.smtc.menu.ConsoleScanner;

public class ExtendThread implements ConsoleExample {
    private boolean threadInterrupt;
    private int threadCount;

    public ExtendThread() {
        this.threadInterrupt = true;
        this.threadCount = 50;
    }

    public ExtendThread(int threadCount, boolean threadInterrupt) {
        this.threadInterrupt = threadInterrupt;
        this.threadCount = threadCount;
    }

    @Override
    public void execute() {
        ConsoleScanner in = new ConsoleScanner(System.in);
        System.out.print("> press Enter to run second thread.");
        in.waitForInput();

        TestThread thread = new TestThread(1, threadCount, true);
        thread.start();
        System.out.println("> second thread is running!");

        System.out.println("> press Enter to print message from main thread.");
        while(thread.isAlive()) {
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
        return "Extend Thread class";
    }
}
