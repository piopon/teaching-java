package pl.smtc.threads.comm.future;

import java.util.Random;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    private int maxWaitTime;
    private int exceptionTime;
    private Random random = new Random();

    public MyCallable(int maxWaitTime, int exceptionTime) {
        this.maxWaitTime = maxWaitTime;
        this.exceptionTime = exceptionTime;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("MyCallable -> start");
        int waitTime = random.nextInt(maxWaitTime);

        if (waitTime >= exceptionTime) {
            throw new IllegalArgumentException("current wait time (" + waitTime + ") is to big!");
        }

        Thread.sleep(waitTime);
        System.out.println("MyCallable -> stop (execution time: " + waitTime + ")");
        return waitTime;
    }
}
