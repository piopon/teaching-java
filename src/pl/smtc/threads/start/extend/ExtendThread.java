package pl.smtc.threads.start.extend;

import pl.smtc.menu.ConsoleExample;

import java.util.Scanner;

public class ExtendThread implements ConsoleExample {
    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.print("> press Enter to run second thread...");
        in.nextLine();

        TestThread thread = new TestThread(1, true);
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
        return "Extend Thread class";
    }
}
