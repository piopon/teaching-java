package pl.smtc.threads.locks.optimistic;

import pl.smtc.menu.ConsoleExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

public class OptimisticLock implements ConsoleExample {
    private StampedLock lock = new StampedLock();
    private int destinationValue = 10;
    private int sourceValue = 0;
    private int readTries = 3;
    private int fillerHeadsUp;
    private int writeSimTime;
    private int readSimTime;

    public OptimisticLock() {
        this.fillerHeadsUp = 500;
        writeSimTime = 1000;
        readSimTime = 1000;
    }

    public OptimisticLock(int fillerHeadsUp, int writeSimTime, int readSimTime) {
        this.fillerHeadsUp = fillerHeadsUp;
        this.writeSimTime = writeSimTime;
        this.readSimTime = readSimTime;
    }

    @Override
    public void execute() {
        try {
            ExecutorService executor = Executors.newFixedThreadPool(2);
            executor.submit(fillerRunnable);
            Thread.sleep(fillerHeadsUp);
            executor.submit(writerRunnable);
            executor.shutdown();
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getName() {
        return "Optimistic lock example";
    }

    private Runnable writerRunnable = () -> {
        System.out.println("WRITER -> run [start].");
        long stamp = lock.writeLock();
        try {
            System.out.println("WRITER -> write start");
            long maxTime = TimeUnit.NANOSECONDS.convert(writeSimTime,TimeUnit.MILLISECONDS);
            long endTime = System.nanoTime() + maxTime;
            for (long currentTime = 0; currentTime < endTime; currentTime = System.nanoTime()) {
                sourceValue++;
                Thread.sleep(150);
            }
            System.out.println("WRITER -> write stop at value: " + sourceValue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock(stamp);
        }
        System.out.println("WRITER -> run [stop].");
    };

    private Runnable fillerRunnable = () -> {
        System.out.println("FILLER -> run [start].");
        long stamp = lock.tryOptimisticRead();
        try {
            for (int i = 0; i < readTries; i++) {
                System.out.println("FILLER -> optimistic lock valid? " + lock.validate(stamp));
                Thread.sleep(readSimTime);
            }
            stamp = lock.readLock();
            if (sourceValue < destinationValue) {
                System.out.println("FILLER -> writer didn't finished. Current value: " + sourceValue);
                stamp = lock.tryConvertToWriteLock(stamp);
                if (stamp == 0L) {
                    System.out.println("FILLER -> could not convert to write lock.");
                    stamp = lock.writeLock();
                } else {
                    System.out.println("FILLER -> converted to write lock.");
                }
                System.out.println("FILLER -> filling variable to reach " + destinationValue);
                sourceValue = destinationValue;
            } else {
                System.out.println("FILLER -> writer finished. Current value: " + sourceValue);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock(stamp);
        }
        System.out.println("FILLER -> run [stop].");
    };
}
