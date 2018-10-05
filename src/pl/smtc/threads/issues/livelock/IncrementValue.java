package pl.smtc.threads.issues.livelock;

public class IncrementValue {
    private int ownersCount = 0;
    private int value = 0;
    private PoliteWorker owner;
    private int maxOwnerChange;

    public IncrementValue(PoliteWorker owner, int maxOwnerChange) {
        this.maxOwnerChange = maxOwnerChange;
        this.owner = owner;
    }

    public PoliteWorker getOwner() {
        return owner;
    }

    public int getValue() {
        return value;
    }

    public boolean ownersLimitReached() {
        return ownersCount > maxOwnerChange;
    }

    public synchronized void setOwner(PoliteWorker owner) {
        this.owner = owner;
        ownersCount++;
    }

    public synchronized void increment(int times) {
        for (int i = 0; i < times; i++) {
            value++;
        }
        ownersCount = 0;
    }
}
