package pl.smtc.threads.sync.latch;

import pl.smtc.menu.ConsoleExample;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountdownLatch implements ConsoleExample {
    private int minTime;
    private int maxTime;
    Random random = new Random();

    public CountdownLatch() {
        this.minTime = 500;
        this.maxTime = 2000;
    }

    public CountdownLatch(int minTime, int maxTime) {
        this.minTime = minTime;
        this.maxTime = maxTime;
    }

    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.print("> input start value: ");
        int startValue = in.nextInt();
        try {
            CountDownLatch countDownLatch = new CountDownLatch(startValue);
            ExecutorService executors = Executors.newFixedThreadPool(startValue);
            for (int i = 0; i < startValue; i++) {
                int randomTime = random.nextInt(maxTime + 1 - minTime) + minTime;
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
