package pl.smtc.threads.issues.deadlock;

import pl.smtc.menu.ConsoleExample;

import java.util.Scanner;

public class ThreadsDeadlock implements ConsoleExample {
    private int sendMaxTime;
    private int receiveMaxTime;
    private int lockWaitTimeout;

    public ThreadsDeadlock() {
        this.sendMaxTime = 2500;
        this.receiveMaxTime = 2500;
        this.lockWaitTimeout = 5000;
    }

    public ThreadsDeadlock(int sendMaxTime, int receiveMaxTime, int lockWaitTimeout) {
        this.sendMaxTime = sendMaxTime;
        this.receiveMaxTime = receiveMaxTime;
        this.lockWaitTimeout = lockWaitTimeout;
    }

    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.print("> press Enter to start threads.");
        in.nextLine();

        CommunicationObject commObject = new CommunicationObject(sendMaxTime, receiveMaxTime, lockWaitTimeout);
        Thread txThread = createThread("SendThread", commObject::send);
        Thread rxThread = createThread("ReceiveThread", commObject::receive);
        try {
            txThread.start();
            rxThread.start();
            txThread.join();
            rxThread.join();
        } catch (InterruptedException e) {
            System.out.println("> deadlock example interrupted!");
        }
    }

    @Override
    public String getName() {
        return "Threads deadlock";
    }

    private Thread createThread(String title, Runnable action) {
        return new Thread(() -> {
            try {
                action.run();
            } catch (Exception e) {
                System.out.println(title + " exception: " + e.getMessage());
            }
        });
    }
}
