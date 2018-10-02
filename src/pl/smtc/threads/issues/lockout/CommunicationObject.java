package pl.smtc.threads.issues.lockout;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class CommunicationObject {
    private int sendTime;
    private int receiveTime;
    private int waitTimeout;

    public CommunicationObject(int sendTime, int receiveTime, int waitTimeout) {
        this.sendTime = sendTime;
        this.receiveTime = receiveTime;
        this.waitTimeout = waitTimeout;
    }

    public void send() {
        try {
            System.out.println("CommObjectSend -> send procedure [start]");

            synchronized (this) {
                System.out.println("CommObjectSend -> preparing data to send.");
                Thread.sleep(sendTime);
                System.out.println("CommObjectSend -> send ok!");
                notify();
            }

            synchronized (this) {
                System.out.println("CommObjectSend -> waiting for handshake...");
                if (waitWithTimer() < waitTimeout) {
                    System.out.println("CommObjectSend -> handshake ok!");
                } else {
                    System.out.println("CommObjectSend -> timeout reached = nested lockout!");
                    return;
                }
            }

            System.out.println("CommObjectSend -> send procedure [stop]");
        } catch (InterruptedException e) {
            System.out.println("CommObjectSend -> interrupted!");
        }
    }

    public void receive() {
        try {
            System.out.println("CommObjectReceive -> receive procedure [start]");

            synchronized (this) {
                System.out.println("CommObjectReceive -> waiting for data...");
                if (waitWithTimer() < waitTimeout) {
                    System.out.println("CommObjectReceive -> data received!");
                } else {
                    System.out.println("CommObjectReceive -> timeout reached = nested lockout!");
                    return;
                }
            }

            synchronized (this) {
                System.out.println("CommObjectReceive -> preparing handshake. ");
                Thread.sleep(receiveTime);
                System.out.println("CommObjectReceive -> handshake ok!");
                notify();
            }

            System.out.println("CommObjectReceive -> receive procedure [stop]");
        } catch (InterruptedException e) {
            System.out.println("CommObjectReceive -> interrupted!");
        }

    }

    private long waitWithTimer() throws InterruptedException {
        long tick = System.nanoTime();
        wait(waitTimeout);
        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - tick);
    }
}
