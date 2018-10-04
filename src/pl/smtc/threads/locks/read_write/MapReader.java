package pl.smtc.threads.locks.read_write;

import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;

public class MapReader implements Runnable {
    private int id;
    private int waitTime;
    private ReadWriteLock lock;
    private Map<String, String> sourceMap;

    public MapReader(int id, ReadWriteLock lock, Map<String, String> sourceMap, int waitTime) {
        this.id = id;
        this.waitTime = waitTime;
        this.lock = lock;
        this.sourceMap = sourceMap;
    }

    @Override
    public void run() {
        System.out.println("MapReader " + id + " -> run [start]");
        lock.readLock().lock();
        try {
            System.out.println("MapReader " + id + " -> got value: " + sourceMap.get("testKey"));
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            System.out.println("MapReader " + id + " -> interrupted!");
        } finally {
            lock.readLock().unlock();
        }
        System.out.println("MapReader " + id + " -> run [stop]");
    }
}
