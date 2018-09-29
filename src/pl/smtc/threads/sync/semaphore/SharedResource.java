package pl.smtc.threads.sync.semaphore;

import java.util.concurrent.Semaphore;

public class SharedResource {
    private final static int MAX_CLIENTS = 3;
    private static SharedResource SHARED_RESOURCE = new SharedResource("FTP", MAX_CLIENTS);
    private String id;
    private Semaphore semaphore;

    private SharedResource(String id, int maxClients) {
        this.id = id;
        semaphore = new Semaphore(maxClients);
    }

    public static SharedResource getInstance() {
        return SHARED_RESOURCE;
    }

    public void access(int simTime) {
        try {
            semaphore.acquire();
            action(simTime);
            semaphore.release();
        } catch (InterruptedException e) {
            System.out.println(id + " access interrupted!");
        }
    }

    private void action(int simTime) throws InterruptedException {
        int connections = MAX_CLIENTS - semaphore.availablePermits();
        System.out.println(id + " access OK [current connections: " + connections + "]");
        Thread.sleep(simTime);
    }

}
