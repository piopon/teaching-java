package pl.smtc.threads.sync.latch;

import java.util.concurrent.CountDownLatch;

public class TestThread implements Runnable {
    private int id;
    private int workTime;
    private CountDownLatch latch;

    public TestThread(int id, int workTime, CountDownLatch latch) {
        this.id = id;
        this.workTime = workTime;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            System.out.println("TestThread " + id + " -> run [start]");
            Thread.sleep(workTime);
            latch.countDown();
            System.out.println("TestThread " + id + " -> run [stop (time: " + workTime + ")]");
        } catch (InterruptedException e) {
            System.out.println("TestThread " + id + " -> interrupted!");
        }
    }
}
