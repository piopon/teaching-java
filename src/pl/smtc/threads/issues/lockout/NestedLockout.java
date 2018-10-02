package pl.smtc.threads.issues.lockout;

import pl.smtc.menu.ConsoleExample;

import java.util.Scanner;

public class NestedLockout implements ConsoleExample {
    private int sendTime;
    private int receiveTime;
    private int waitTimeout;

    public NestedLockout() {
        this.sendTime = 1000;
        this.receiveTime = 1000;
        this.waitTimeout = 10000;
    }

    public NestedLockout(int sendTime, int receiveTime, int waitTimeout) {
        this.sendTime = sendTime;
        this.receiveTime = receiveTime;
        this.waitTimeout = waitTimeout;
    }

    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.println("> press Enter to start threads.");
        in.nextLine();

        CommunicationObject commObject = new CommunicationObject(sendTime, receiveTime, waitTimeout);
        Thread txThread = createThread("SendThread", commObject::send);
        Thread rxThread = createThread("ReceiveThread", commObject::receive);
        try {
            txThread.start();
            rxThread.start();
            txThread.join();
            rxThread.join();
        } catch (InterruptedException e) {
            System.out.println("> lockout example interrupted!");
        }
    }

    @Override
    public String getName() {
        return "Nested monitor lockout";
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

    private void clearInput(Scanner input) {
        input.nextLine();
    }
}
