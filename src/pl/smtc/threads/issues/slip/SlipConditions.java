package pl.smtc.threads.issues.slip;

import pl.smtc.menu.ConsoleExample;

public class SlipConditions implements ConsoleExample {
    private TestLock testLock = new TestLock();
    private int simWorkTime;

    public SlipConditions() {
        this.simWorkTime = 1000;
    }

    public SlipConditions(int simWorkTime) {
        this.simWorkTime = simWorkTime;
    }

    @Override
    public void execute() {
        Thread thread1 = createThread(1,simWorkTime);
        Thread thread2 = createThread(2,simWorkTime);
        thread1.start();
        thread2.start();
        waitThread(thread1,200);
        waitThread(thread2,200);
    }

    @Override
    public String getName() {
        return "Slipped conditions";
    }

    private Thread createThread(int id, int simTime) {
        return new Thread(() -> {
            try {
                testLock.lock("Thread " + id);
                System.out.println("Thread " + id + " -> working...");
                Thread.sleep(simTime);
                testLock.unlock("Thread " + id);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private void waitThread(Thread thread, int checkInterval) {
        do {
            try {
                Thread.sleep(checkInterval);
            } catch (InterruptedException e) {
                System.out.print("Interrupt while sleeping...");
            }
        } while (thread.isAlive());
    }
}
