package pl.smtc.threads.issues.deadlock;

import pl.smtc.menu.ConsoleExample;

import java.util.Scanner;

public class ThreadsDeadlock implements ConsoleExample {
    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.print("> press Enter to start threads.");
        in.nextLine();

        CommunicationObject commObject = new CommunicationObject();
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
