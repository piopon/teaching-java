package pl.smtc.threads.locks.stamped;

import java.util.Map;
import java.util.concurrent.locks.StampedLock;


public class MapReader implements Runnable {
    private int id;
    private int waitTime;
    private StampedLock lock;
    private Map<Integer, Integer> readMap;

    public MapReader(int id, StampedLock lock, Map<Integer, Integer> readMap, int waitTime) {
        this.id = id;
        this.waitTime = waitTime;
        this.lock = lock;
        this.readMap = readMap;
    }

    @Override
    public void run() {
        System.out.println("MapReader " + id + " -> run [start]");
        long stamp = lock.writeLock();
        try {
            System.out.println("MapReader " + id + " -> got value: " + readMap.get(100));
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            System.out.println("MapReader " + id + " -> interrupted!");
        } finally {
            lock.unlock(stamp);
        }
        System.out.println("MapReader " + id + " -> run [stop]");
    }
}
