package pl.smtc.threads.locks.reentrant;

import pl.smtc.menu.ConsoleExample;

import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample implements ConsoleExample {
    private Lock lock = new ReentrantLock();
    private int threadsNo = 2;

    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        IncrementValue incrementValue = new IncrementValue();
        System.out.print("> how many times to increment value: ");
        int incrementTimes = in.nextInt();
        System.out.print("> press Enter to start.");
        waitEnterKey(in);

        Thread thread1 = new Thread(new WorkerThread(1, lock, incrementValue, incrementTimes));
        Thread thread2 = new Thread(new WorkerThread(2, lock, incrementValue, incrementTimes));
        thread1.start();
        thread2.start();
        waitThread(thread1);
        waitThread(thread2);

        int currentValue = incrementValue.getValue();
        int expectedValue = incrementTimes * threadsNo;
        System.out.println("> final value: " + currentValue + " (expected: " + expectedValue + ")");
    }

    @Override
    public String getName() {
        return "Reentrant lock example";
    }

    private void waitEnterKey(Scanner scanner) {
        scanner.nextLine(); //clear buffer
        scanner.nextLine(); //wait for return key
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
