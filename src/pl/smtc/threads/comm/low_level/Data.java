package pl.smtc.threads.comm.low_level;

public class Data {
    private int value;
    private boolean empty = true;

    public synchronized int receive() throws InterruptedException {
        while (empty) {
            wait();
        }
        empty = true;
        notifyAll();
        return value;
    }

    public synchronized void send(int value) throws InterruptedException {
        while (!empty) {
            wait();
        }
        empty = false;
        notifyAll();
        this.value = value;
    }
}
