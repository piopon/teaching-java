package pl.smtc.threads.sync.block;

import pl.smtc.menu.ConsoleExample;

import java.util.Scanner;

public class SyncBlock implements ConsoleExample {
    private Countdown commonCountdown;

    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input start value: ");
        int startValue = in.nextInt();

        commonCountdown = new Countdown(startValue);

        Thread thread1 = createThread("Thread 1");
        Thread thread2 = createThread("Thread 2");
        thread1.start();
        thread2.start();
        threadWait(thread1, 250);
        threadWait(thread2, 250);
    }

    @Override
    public String getName() {
        return "Synchronized block";
    }

    private Thread createThread(String title) {
        return new Thread(() -> commonCountdown.countdown(title));
    }

    private void threadWait(Thread thread, int millis) {
        do {
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                System.out.print("Interrupt while sleeping...");
            }
        } while (thread.isAlive());
    }
}
