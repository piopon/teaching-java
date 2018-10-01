package pl.smtc.threads.comm.advanced;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CommunicationObject {
    private BlockingQueue<Integer> queue;
    private Random random = new Random();
    private int testMin;
    private int testMax;

    public CommunicationObject(int bufferSize, int testMin, int testMax) {
        queue = new ArrayBlockingQueue<>(bufferSize);
        this.testMin = testMin;
        this.testMax = testMax;
    }

    public void send() {
        boolean run = true;
        System.out.println("CommObjectSend -> start");
        while (run) {
            try {
                int sendInt = random.nextInt(testMax + 1 - testMin) + testMin;
                queue.put(sendInt);
                System.out.println("CommObjectSend -> send: " + sendInt);
                sleepRandom(300);
            } catch (InterruptedException e) {
                run = false;
            }
        }
        System.out.println("CommObjectSend -> stop");
    }

    public void receive() {
        boolean run = true;
        System.out.println("CommObjectReceive -> start");
        while (run) {
            try {
                sleepRandom(500);
                int receivedInt = queue.take();
                System.out.println("CommObjectSend -> receive: " + receivedInt);

            } catch (InterruptedException e) {
                run = false;
            }
        }
        System.out.println("CommObjectReceive -> stop");
    }

    private void sleepRandom(int maxTime) throws InterruptedException {
        Thread.sleep(random.nextInt(maxTime));
    }
}
