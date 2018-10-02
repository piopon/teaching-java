package pl.smtc.threads.comm.low_level;

import java.util.Random;

public class Receiver implements Runnable {
    private Random random = new Random();
    private Data data;
    private int maxInterval;
    private int dataCounter = 0;

    public Receiver(Data data, int maxInterval) {
        this.data = data;
        this.maxInterval = maxInterval;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(random.nextInt(maxInterval));
                int latestData = data.receive();
                System.out.println("Receiver -> got item: " + latestData);
                dataCounter++;
            } catch (InterruptedException e) {
                System.out.println("Receiver -> interrupted (items received: " + dataCounter + ")!");
                break;
            }
        }
    }
}
