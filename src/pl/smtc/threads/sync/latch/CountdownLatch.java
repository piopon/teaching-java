package pl.smtc.threads.sync.latch;

import pl.smtc.menu.ConsoleExample;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountdownLatch implements ConsoleExample {
    private final static int MIN_TIME = 500;
    private final static int MAX_TIME = 2000;
    Random random = new Random();

    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.print("> input start value: ");
        int startValue = in.nextInt();
        try {
            CountDownLatch countDownLatch = new CountDownLatch(startValue);
            ExecutorService executors = Executors.newFixedThreadPool(startValue);
            for (int i = 0; i < startValue; i++) {
                int randomTime = random.nextInt(MAX_TIME + 1 - MIN_TIME) + MIN_TIME;
                executors.submit(new TestThread(i, randomTime, countDownLatch));
            }
            countDownLatch.await();
        } catch (InterruptedException e) {
            System.out.println("> countdown await interrupted...");
        }
        System.out.println("> countdown with latch completed.");
    }

    @Override
    public String getName() {
        return "Countdown latch";
    }
}
