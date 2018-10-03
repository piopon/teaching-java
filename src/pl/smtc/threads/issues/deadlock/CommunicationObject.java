package pl.smtc.threads.issues.deadlock;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class CommunicationObject {
    private Random random = new Random();
    private final TestLock LOCK1 = new TestLock("LOCK 1", new ReentrantLock());
    private final TestLock LOCK2 = new TestLock("LOCK 2", new ReentrantLock());
    private int sendMaxTime;
    private int receiveMaxTime;
    private int lockWaitTimeout;

    public CommunicationObject() {
        this.sendMaxTime = 2500;
        this.receiveMaxTime = 2500;
        this.lockWaitTimeout = 5000;
    }

    public CommunicationObject(int sendMaxTime, int receiveMaxTime, int lockWaitTimeout) {
        this.sendMaxTime = sendMaxTime;
        this.receiveMaxTime = receiveMaxTime;
        this.lockWaitTimeout = lockWaitTimeout;
    }

    public void send() {
        acquireLocks("CommObjectSend", random.nextInt(sendMaxTime), LOCK1, LOCK2);
    }

    public void receive() {
        acquireLocks("CommObjectReceive", random.nextInt(receiveMaxTime), LOCK2, LOCK1);
    }

    private void acquireLocks(String titleId, int workSimTime, TestLock... lockSequence) {
        if (lockSequence.length < 2) {
            System.out.println(titleId + " -> minimum two locks are required!");
            return;
        }
        try {
            if (!getLock(titleId, lockSequence[0], lockWaitTimeout)) {
                return;
            }
            System.out.println(titleId + " -> sim work time: " + workSimTime);
            Thread.sleep(workSimTime);
            if (!getLock(titleId, lockSequence[1], lockWaitTimeout)) {
                return;
            }
            unlock(lockSequence);
        } catch (InterruptedException e) {
            System.out.println(titleId + " -> interrupt!");
        }
    }

    private boolean getLock(String parent, TestLock lock, int millis) throws InterruptedException {
        System.out.println(parent + " -> wait " + lock.getName());
        if (lock.getLock().tryLock(millis, TimeUnit.MILLISECONDS)) {
            System.out.println(parent + "-> got " + lock.getName());
        } else {
            System.out.println(parent + " -> deadlock!");
            return false;
        }
        return true;
    }

    private void unlock(TestLock... locks) {
        for (int i = 0; i < locks.length; i++) {
            locks[i].getLock().unlock();
        }
    }
}
