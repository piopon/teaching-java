package pl.smtc.threads.comm.advanced;

import pl.smtc.menu.ConsoleExample;

import java.util.Scanner;

public class ProducerConsumer implements ConsoleExample {
    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.print("> input minimum number to send/receive: ");
        int minVal = in.nextInt();
        System.out.print("> input maximum number to send/receive: ");
        int maxVal = in.nextInt();
        CommunicationObject commObject = new CommunicationObject(10, minVal, maxVal);

        System.out.println("> press Enter to stop execution.");
        Thread rxThread = createThread("ReceiveThread", commObject::receive);
        Thread txThread = createThread("SendThread", commObject::send);
        rxThread.start();
        txThread.start();

        in.nextLine(); // clear return key pressed from input
        in.nextLine(); // wait for current enter key

        threadStopAndWait(rxThread, 200);
        threadStopAndWait(txThread, 200);
    }

    @Override
    public String getName() {
        return "Producer-consumer pattern";
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

    private void threadStopAndWait(Thread thread, int millis) {
        thread.interrupt();
        do {
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                System.out.print("Interrupt while sleeping...");
            }
        } while (thread.isAlive());
    }
}
