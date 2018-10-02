package pl.smtc.threads.comm.low_level;

import java.util.Random;

public class Sender implements Runnable {
    private Random random = new Random();
    private Data data;
    private int minValue;
    private int maxValue;
    private int maxInterval;
    private int dataCounter = 0;

    public Sender(Data data, int minValue, int maxValue, int maxInterval) {
        this.data = data;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.maxInterval = maxInterval;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int sendInt = random.nextInt(maxValue + 1 - minValue) + minValue;
                data.send(sendInt);
                System.out.println("Sender -> sent item: " + sendInt);
                dataCounter++;
                Thread.sleep(random.nextInt(maxInterval));
            } catch (InterruptedException e) {
                System.out.println("Sender -> interrupted (items sent: " + dataCounter + ")!");
                break;
            }
        }
    }
}
