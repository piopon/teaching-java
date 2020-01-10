package pl.smtc.threads.locks.read_write;

import pl.smtc.menu.ConsoleExample;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteExample implements ConsoleExample {
    private int writerWaitTime;
    private int readerWaitTime;

    public ReadWriteExample() {
        this.readerWaitTime = 100;
        this.writerWaitTime = 1000;
    }

    public ReadWriteExample(int readerWaitTime, int writerWaitTime) {
        this.readerWaitTime = readerWaitTime;
        this.writerWaitTime = writerWaitTime;
    }

    @Override
    public void execute() {
        Map<String, String> map = new HashMap<>();
        ReadWriteLock lock = new ReentrantReadWriteLock();
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
        return "Read write lock example";
    }
}
