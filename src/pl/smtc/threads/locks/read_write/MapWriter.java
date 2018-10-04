package pl.smtc.threads.locks.read_write;

import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;

public class MapWriter implements Runnable {
    private int id;
    private int waitTime;
    private ReadWriteLock lock;
    private Map<String, String> sourceMap;

    public MapWriter(int id, ReadWriteLock lock, Map<String, String> sourceMap, int waitTime) {
        this.id = id;
        this.waitTime = waitTime;
        this.lock = lock;
        this.sourceMap = sourceMap;
    }

    @Override
    public void run() {
        System.out.println("MapWriter " + id + " -> run [start]");
        lock.writeLock().lock();
        try {
            System.out.println("MapWriter " + id + " -> working...");
            Thread.sleep(waitTime);
            sourceMap.put("testKey", "testValue");
            System.out.println("MapWriter " + id + " -> added [testKey, testValue].");
        } catch (InterruptedException e) {
            System.out.println("MapWriter " + id + " -> interrupted!");
        } finally {
            lock.writeLock().unlock();
        }
        System.out.println("MapWriter " + id + " -> run [stop]");
    }
}
