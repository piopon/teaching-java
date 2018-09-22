package pl.smtc.threads.start.implement;

import pl.smtc.menu.ConsoleExample;

import java.util.Scanner;

public class ImplementRunnable implements ConsoleExample {
    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.print("> press Enter to run second thread...");
        in.nextLine();

        TestThread testThread = new TestThread(1, true);
        Thread thread = new Thread(testThread);
        thread.start();
        System.out.println("> second thread is running!");

        System.out.println("> press Enter to print message...");
        while(thread.isAlive()) {
            in.nextLine();
            System.out.println("> MESSAGE FROM MAIN THREAD" + System.lineSeparator());
        }
        System.out.println("> press Enter to go back to menu...");
        in.nextLine();
    }

    @Override
    public String getName() {
        return "Implement Runnable interface";
    }
}