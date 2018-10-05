package pl.smtc.threads.locks.stamped;

import java.util.Map;
import java.util.concurrent.locks.StampedLock;

public class MapWriter implements Runnable {
    private int id;
    private int waitTime;
    private StampedLock lock;
    private Map<Integer, Integer> writeMap;

    public MapWriter(int id, StampedLock lock, Map<Integer, Integer> writeMap, int waitTime) {
        this.id = id;
        this.waitTime = waitTime;
        this.lock = lock;
        this.writeMap = writeMap;
    }

    @Override
    public void run() {
        System.out.println("MapWriter " + id + " -> run [start]");
        long stamp = lock.writeLock();
        try {
            System.out.println("MapWriter " + id + " -> working...");
            Thread.sleep(waitTime);
            writeMap.put(100, -100);
            System.out.println("MapWriter " + id + " -> added [100, -100].");
        } catch (InterruptedException e) {
            System.out.println("MapWriter " + id + " -> interrupted!");
        } finally {
            lock.unlock(stamp);
        }
        System.out.println("MapWriter " + id + " -> run [stop]");
    }
}
