package pl.smtc.threads.comm.callable;

import java.util.Random;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    private int maxWaitTime;
    private Random random = new Random();

    public MyCallable(int maxWaitTime) {
        this.maxWaitTime = maxWaitTime;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("MyCallable -> start");
        int waitTime = random.nextInt(maxWaitTime);
        Thread.sleep(waitTime);
        System.out.println("MyCallable -> stop (execution time: " + waitTime + ")");
        return waitTime;
    }
}
