package pl.smtc.threads.comm.low_level;

import java.util.Random;

public class Receiver implements Runnable {
    private Random random = new Random();
    private Data data;
    private int maxInterval;
    private int dataCounterCurrent = 0;
    private int itemsToReceive;

    public Receiver(Data data, int maxInterval, int itemsToReceive) {
        this.data = data;
        this.maxInterval = maxInterval;
        this.itemsToReceive = itemsToReceive;
    }

    @Override
    public void run() {
        while (dataCounterCurrent < itemsToReceive) {
            try {
                Thread.sleep(random.nextInt(maxInterval));
                int latestData = data.receive();
                System.out.println("Receiver -> got item: " + latestData);
                dataCounterCurrent++;
            } catch (InterruptedException e) {
                System.out.println("Receiver -> interrupted (items received: " + dataCounterCurrent + ")!");
                return;
            }
        }
        System.out.println("Receiver -> finished (items received: " + dataCounterCurrent + ")!");
    }
}
