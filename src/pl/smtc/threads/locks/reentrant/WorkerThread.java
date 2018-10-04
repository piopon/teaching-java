package pl.smtc.threads.locks.reentrant;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class WorkerThread implements Runnable {
    private int id;
    private int times;
    private Lock lock;
    private IncrementValue incrementValue;

    public WorkerThread(int id, Lock lock, IncrementValue incrementValue, int times) {
        this.id = id;
        this.lock = lock;
        this.incrementValue = incrementValue;
        this.times = times;
    }

    @Override
    public void run() {
        try {
            if (lock.tryLock(1, TimeUnit.MINUTES)) {
                incrementValue.increment(times);
            } else {
                Thread.currentThread().interrupt();
            }
        } catch (InterruptedException e) {
            System.out.println("WorkerThread " + id + " interrupted or timeout!");
        } finally {
            lock.unlock();
        }
    }
}

