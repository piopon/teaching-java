package pl.smtc.threads.comm.low_level;

import java.util.concurrent.TimeUnit;

public class Data {
    private int value;
    private long receiveWait;
    private long sendWait;
    private boolean empty = true;

    public Data() {
        this.receiveWait = TimeUnit.DAYS.toMillis(1);
        this.sendWait = TimeUnit.DAYS.toMillis(1);
    }

    public Data(long receiveWait, long sendWait) {
        this.receiveWait = receiveWait;
        this.sendWait = sendWait;
    }

    public synchronized int receive() throws InterruptedException {
        while (empty) {
            wait(receiveWait);
        }
        empty = true;
        notifyAll();
        return value;
    }

    public synchronized void send(int value) throws InterruptedException {
        while (!empty) {
            wait(sendWait);
        }
        empty = false;
        notifyAll();
        this.value = value;
    }

    protected int getStoredValue() {
        return value;
    }
}
