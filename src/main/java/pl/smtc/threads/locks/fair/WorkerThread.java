package pl.smtc.threads.locks.fair;

import java.util.concurrent.locks.Lock;

public class WorkerThread implements Runnable {
    Lock lock;
    private String name;
    private int maxCount;

    public WorkerThread(Lock lock, String name, int maxCount) {
        this.lock = lock;
        this.name = name;
        this.maxCount = maxCount;
    }

    @Override
    public void run() {
        long startTime = System.nanoTime();
        doWork();
        double executionTime = (System.nanoTime() - startTime) / 1E6;
        System.out.println(name + " -> executionTime: " + executionTime + "[ms]");
    }

    private void doWork() {
        for (int i = 0; i < maxCount; i++) {
            lock.lock();
            try {
                if (i % 100 == 0) {
                    String someActionToDo = name + " -> count: " + i;
                    System.out.println(someActionToDo);
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
