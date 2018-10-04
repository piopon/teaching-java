package pl.smtc.threads.locks.simple;

import pl.smtc.menu.ConsoleExample;

import java.util.Random;

public class SimpleLock implements ConsoleExample {
    private Random random = new Random();
    private Lock myLock = new Lock();
    private int startValue;
    private int countdownValue;
    private int waitTime;

    public SimpleLock() {
        this.startValue = 10;
        this.countdownValue = 10;
        this.waitTime = 1000;
    }

    public SimpleLock(int startValue, int countdownValue, int waitTime) {
        this.startValue = startValue;
        this.countdownValue = countdownValue;
        this.waitTime = waitTime;
    }

    @Override
    public void execute() {
        Thread thread1 = createThread(1, waitTime);
        Thread thread2 = createThread(2, waitTime);
        thread1.start();
        thread2.start();
        waitThread(thread1);
        waitThread(thread2);
    }

    @Override
    public String getName() {
        return "Simple lock implementation";
    }

    private Thread createThread(int id, int waitTime) {
        return new Thread(() -> {
            try {
                myLock.lock();
                System.out.println("Thread " + id + " start value: " + startValue);
                System.out.print("  +--> Countdown: ");
                for (int i = countdownValue; i > 0; i--) {
                    startValue--;
                    Thread.sleep(random.nextInt(waitTime));
                    System.out.print(startValue + "  ");
                }
                System.out.println(" ");
                myLock.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private void waitThread(Thread thread) {
        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.print("Interrupt while sleeping...");
            }
        } while (thread.isAlive());
    }

}



