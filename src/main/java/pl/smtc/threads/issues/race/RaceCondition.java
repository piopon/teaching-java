package pl.smtc.threads.issues.race;

import pl.smtc.menu.ConsoleExample;

import java.util.Scanner;

public class RaceCondition implements ConsoleExample {
    private Iterate commonIterate;

    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input end value: ");
        int endValue = in.nextInt();

        commonIterate = new Iterate(endValue);

        Thread thread1 = createThread("Thread 1");
        Thread thread2 = createThread("Thread 2");
        thread1.start();
        thread2.start();
        threadWait(thread1, 250);
        threadWait(thread2, 250);
    }

    @Override
    public String getName() {
        return "Race condition";
    }

    private Thread createThread(String title) {
        return new Thread(() -> commonIterate.iterate(title));
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
