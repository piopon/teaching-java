package pl.smtc.threads.start.extend;

public class TestThread extends Thread {
    private final int id;
    private final boolean showCounter;

    public TestThread(int id, boolean showCounter) {
        this.id = id;
        this.showCounter = showCounter;
    }

    @Override
    public void run() {
        System.out.println("TestThread " + id + " -> run [start]");
        for (int i = 0; i < 50; i++) {
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
