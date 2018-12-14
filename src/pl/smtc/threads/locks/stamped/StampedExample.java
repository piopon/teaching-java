package pl.smtc.threads.locks.stamped;

import pl.smtc.menu.ConsoleExample;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

public class StampedExample implements ConsoleExample {
    private int writerWaitTime;
    private int readerWaitTime;

    public StampedExample() {
        this.writerWaitTime = 1000;
        this.readerWaitTime = 100;
    }

    public StampedExample(int writerWaitTime, int readerWaitTime) {
        this.writerWaitTime = writerWaitTime;
        this.readerWaitTime = readerWaitTime;
    }


    @Override
    public void execute() {
        Map<Integer, Integer> map = new HashMap<>();
        StampedLock lock = new StampedLock();
        try {
            ExecutorService executorService = Executors.newFixedThreadPool(3);

            executorService.submit(new MapWriter(1, lock, map, writerWaitTime));
            Thread.sleep(100);
            executorService.submit(new MapReader(1, lock, map, readerWaitTime));
            executorService.submit(new MapReader(2, lock, map, readerWaitTime));

            executorService.shutdown();
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            System.out.println("> read write lock interrupted!");
        }
    }

    @Override
    public String getName() {
        return "Stamped lock example";
    }
}
