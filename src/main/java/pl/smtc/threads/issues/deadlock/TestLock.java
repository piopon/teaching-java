package pl.smtc.threads.issues.deadlock;

import java.util.concurrent.locks.Lock;

public class TestLock {
    private String name;
    private Lock lock;

    public TestLock(String name, Lock lock) {
        this.name = name;
        this.lock = lock;
    }

    public String getName() {
        return name;
    }

    public Lock getLock() {
        return lock;
    }
}
