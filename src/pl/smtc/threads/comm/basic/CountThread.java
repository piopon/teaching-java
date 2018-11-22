package pl.smtc.threads.comm.basic;

public class CountThread extends Thread {
    protected volatile boolean run = true;
    protected volatile boolean showCounter;
    private int maxCount;
    private int id;

    public CountThread(int id, boolean showCounter) {
        this.id = id;
        this.showCounter = showCounter;
        this.maxCount = 0;
    }

    public CountThread(int id, int maxCount, boolean showCounter) {
        this.id = id;
        this.showCounter = showCounter;
        this.maxCount = maxCount;
    }

    @Override
    public void run() {
        System.out.println("CountThread " + id + " -> run [start]");
        int currentCounter = 0;
        while (this.run) {
            currentCounter %= 1000;
            if (currentCounter % 5 == 0 && this.showCounter) {
                System.out.println("CountThread " + id + " -> count: " + currentCounter);
            }
            currentCounter++;
            wait(100);
            if(currentCounter > maxCount && maxCount > 0) {
                this.run = false;
            }
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
