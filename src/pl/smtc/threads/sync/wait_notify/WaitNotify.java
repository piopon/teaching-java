package pl.smtc.threads.sync.wait_notify;

import pl.smtc.menu.ConsoleExample;

public class WaitNotify implements ConsoleExample {
    @Override
    public void execute() {
        CommunicationObject commObject = new CommunicationObject();
        Thread rxThread = createThread("ReceiveThread", commObject::receive);
        Thread txThread = createThread("SendThread", commObject::send);
        try {
            rxThread.start();
            txThread.start();
            rxThread.join();
            txThread.join();
        } catch (InterruptedException e) {
            System.out.println("> wait & notify example interrupted!");
        }
    }

    @Override
    public String getName() {
        return "Wait and notify methods";
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
