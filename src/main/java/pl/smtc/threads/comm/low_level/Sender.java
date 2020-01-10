package pl.smtc.threads.comm.low_level;

import java.util.Random;

public class Sender implements Runnable {
    private Random random = new Random();
    private Data data;
    private int minValue;
    private int maxValue;
    private int maxInterval;
    private int dataCounterCurrent = 0;
    private int itemsToSend;

    public Sender(Data data, int minValue, int maxValue, int maxInterval, int itemsToSend) {
        this.data = data;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.maxInterval = maxInterval;
        this.itemsToSend = itemsToSend;
    }

    @Override
    public void run() {
        while (dataCounterCurrent < itemsToSend) {
            try {
                int sendInt = random.nextInt(maxValue + 1 - minValue) + minValue;
                data.send(sendInt);
                System.out.println("Sender -> sent item: " + sendInt);
                dataCounterCurrent++;
                Thread.sleep(random.nextInt(maxInterval));
            } catch (InterruptedException e) {
                System.out.println("Sender -> interrupted (items sent: " + dataCounterCurrent + ")!");
                return;
            }
        }
        System.out.println("Sender -> finished (items sent: " + dataCounterCurrent + ")!");
    }
}
