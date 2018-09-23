package pl.smtc.threads.start.executors;

public class TestThread implements Runnable {
    private final int id;
    private final int maxCount;
    private final boolean showCounter;

    public TestThread(int id, int maxCount, boolean showCounter) {
        this.id = id;
        this.maxCount = maxCount;
        this.showCounter = showCounter;
    }

    @Override
    public void run() {
        System.out.println("TestThread " + id + " -> run [start]");
        for (int i = 0; i < maxCount; i++) {
            if (showCounter && i % 5 == 0) {
                System.out.println("TestThread " + id + " -> counter: " + i);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("TestThread " + id + " -> interrupt!");
            }
        }
        System.out.println("TestThread " + id + " -> run [stop]");
    }
}
