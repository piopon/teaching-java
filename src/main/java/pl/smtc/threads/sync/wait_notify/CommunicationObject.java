package pl.smtc.threads.sync.wait_notify;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class CommunicationObject {
    private long waitTime;

    public CommunicationObject() {
        waitTime = TimeUnit.DAYS.toMillis(1);
    }

    public CommunicationObject(long waitTime) {
        this.waitTime = waitTime;
    }

    public void send() {
        Scanner in = new Scanner(System.in);
        System.out.println("CommObjectSend -> send procedure [start]");
        System.out.print("CommObjectSend -> press Enter to send data. ");
        synchronized (this) {
            in.nextLine();
            notify();
        }
        System.out.println("CommObjectSend -> send procedure [stop]");
    }

    public synchronized void receive() {
        try {
            System.out.println("CommObjectReceive -> receive procedure [start]");
            System.out.println("CommObjectReceive -> waiting for data...");
            wait(waitTime);
            System.out.println("CommObjectReceive -> data received!");
            System.out.println("CommObjectReceive -> receive procedure [stop]");
        } catch (InterruptedException e) {
            System.out.println("CommObjectReceive -> interrupted!");
        }

    }
}
