package pl.smtc.threads.comm.basic;

public class CountThread extends Thread {
    private volatile boolean run = true;
    private volatile boolean showCounter;
    private int id;

    public CountThread(int id, boolean showCounter) {
        this.id = id;
        this.showCounter = showCounter;
    }

    @Override
    public void run() {
        System.out.println("CountThread " + id + " -> run [start]");
        int currentCounter = 0;
        while (this.run) {
            currentCounter %= 1000;
            if (currentCounter % 10 == 0 && this.showCounter) {
                System.out.println("CountThread " + id + " -> count: " + currentCounter);
            }
            currentCounter++;
            wait(100);
        }
        System.out.println("CountThread " + id + " -> run [stop]");
    }

    public void shutdown() {
        this.run = false;
    }

    public void counterOn() {
        this.showCounter = true;
    }

    public void counterOff() {
        this.showCounter = false;
    }

    private void wait(int millis) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.print("CountThread " + id + " -> interrupted!");
        }
    }
}
