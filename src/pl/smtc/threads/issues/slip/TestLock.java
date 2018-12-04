package pl.smtc.threads.issues.slip;

public class TestLock {
    private boolean isLocked = false;

    public void lock(String parentTitle) throws InterruptedException {
        synchronized (this) {
            System.out.println(parentTitle + " -> waiting for lock.");
            while (isLocked) {
                this.wait();
            }
        }
        System.out.println(parentTitle + " -> lock free.");
        synchronized (this) {
            isLocked = true;
            System.out.println(parentTitle + " -> acquired lock.");
        }
    }

    public synchronized void unlock(String parentTitle) {
        isLocked = false;
        System.out.println(parentTitle + " -> released lock.");
        this.notify();
    }
}
