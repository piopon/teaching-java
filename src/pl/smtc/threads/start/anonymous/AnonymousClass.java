package pl.smtc.threads.start.anonymous;

import pl.smtc.menu.ConsoleExample;

import java.util.Scanner;

public class AnonymousClass implements ConsoleExample {
    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.print("> press Enter to run second thread...");
        in.nextLine();

        Thread testThread = new Thread(new Runnable() {
            @Override
            public void run() {
                threadMethod(1, true);
            }
        });
        testThread.start();
        System.out.println("> second thread is running!");

        System.out.println("> press Enter to print message...");
        while(testThread.isAlive()) {
            in.nextLine();
            System.out.println("> MESSAGE FROM MAIN THREAD" + System.lineSeparator());
        }
        System.out.println("> press Enter to go back to menu...");
        in.nextLine();
    }

    @Override
    public String getName() {
        return "Anonymous class usage";
    }

    private void threadMethod(final int id, final boolean showCounter) {
        System.out.println("TestThread " + id + " -> run [start]");
        for (int i = 0; i < 50; i++) {
            if (showCounter && i % 5 == 0) {
                System.out.println("TestThread " + id + " -> counter: " + i);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("TestThread " + id + " -> interrupt!");
            }
        }
        System.out.println("TestThread " + id + " -> run [stop]");
    }
}
