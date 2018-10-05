package pl.smtc.threads.issues.livelock;

public class PoliteWorker {
    private int id;
    private String name;
    private boolean active;

    public PoliteWorker(int id, boolean active) {
        this.id = id;
        this.active = active;
    }

    public String getName() {
        return "PoliteWorker " + id;
    }

    public boolean isActive() {
        return active;
    }

    public synchronized void doWork(IncrementValue value, PoliteWorker siblingWorker) {
        while (active) {
            if(value.getOwner() != this) {
                try {
                    wait(100);
                    if (value.ownersLimitReached()) {
                        break;
                    }
                } catch (InterruptedException e) {
                    // do nothing - just wait more time
                }
                continue;
            }

            if (siblingWorker.isActive()) {
                System.out.println(getName() + ": giving resource to " + siblingWorker.getName());
                value.setOwner(siblingWorker);
                continue;
            }

            System.out.println(getName() + ": working on increment value object");
            value.increment(10);
            value.setOwner(siblingWorker);
        }
    }
}
