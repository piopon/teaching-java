package pl.smtc.threads.sync.wait_notify;

import pl.smtc.menu.ConsoleExample;

import java.util.concurrent.TimeUnit;

public class WaitNotify implements ConsoleExample {
    private long receiveTime;

    public WaitNotify() {
        receiveTime = TimeUnit.DAYS.toMillis(1);
    }

    public WaitNotify(long receiveTime) {
        this.receiveTime = receiveTime;
    }

    @Override
    public void execute() {
        CommunicationObject commObject = new CommunicationObject(receiveTime);
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
