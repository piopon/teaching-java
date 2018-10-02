package pl.smtc.threads.comm.low_level;

import pl.smtc.menu.ConsoleExample;

import java.util.Scanner;

public class LowLevelComm implements ConsoleExample {
    private int maxInterval;
    private int minValue;
    private int maxValue;

    public LowLevelComm() {
        this.maxInterval = 1000;
        this.minValue = -1000;
        this.maxValue = 1000;
    }

    public LowLevelComm(int maxInterval, int minValue, int maxValue) {
        this.maxInterval = maxInterval;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public void execute() {
        Data data = new Data();
        Scanner in = new Scanner(System.in);
        System.out.println("> press Enter to stop threads.");

        Thread sendThread = new Thread(new Sender(data, minValue, maxValue, maxInterval));
        Thread receiveThread = new Thread(new Receiver(data, maxInterval));
        sendThread.start();
        receiveThread.start();

        in.nextLine();

        receiveThread.interrupt();
        sendThread.interrupt();

        threadWait(receiveThread, 200);
        threadWait(sendThread, 200);

    }

    @Override
    public String getName() {
        return "Low level communication";
    }

    private void threadWait(Thread thread, int millis) {
        do {
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                System.out.print("Interrupt while sleeping...");
            }
        } while (thread.isAlive());
    }
}
