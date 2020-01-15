package pl.smtc.threads.stop.variable;

import java.util.concurrent.TimeUnit;

public class CountThread extends Thread {
    private volatile boolean run = true;
    private int id;
    private long timeout = TimeUnit.MINUTES.toNanos(5);

    public CountThread(int id) {
        this.id = id;
    }

    public CountThread(int id, long timeoutMs) {
        this.id = id;
        this.timeout = TimeUnit.MILLISECONDS.toNanos(timeoutMs);
    }

    @Override
    public void run() {
        System.out.println("CountThread " + id + " -> run [start]");
        int currentCounter = 0;
        long startTime = System.nanoTime();
        while (this.run) {
            currentCounter %= 1000;
            if (currentCounter % 10 == 0) {
                System.out.println("CountThread " + id + " -> count: " + currentCounter);
            }
            currentCounter++;
            wait(100);
            if ((System.nanoTime() - startTime) > timeout) {
                System.out.println("CountThread " + id + " -> interrupted!");
                System.out.println("CountThread " + id + " -> counter: " + currentCounter );
                return;
            }
        }
        System.out.println("CountThread " + id + " -> run [stop]");
    }

    public void shutdown() {
        this.run = false;
    }

    protected boolean getRunStatus() {
        return run;
    }

    private void wait(int millis) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.print("CountThread " + id + " -> interrupted!");
        }
    }
}
