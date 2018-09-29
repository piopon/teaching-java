package pl.smtc.threads.stop.variable;

import pl.smtc.menu.ConsoleExample;

import java.util.Scanner;

public class BasicStop implements ConsoleExample {

    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.print("Press Enter to stop counter thread.");

        CountThread testThread = new CountThread(1);
        testThread.start();
        in.nextLine();
        testThread.shutdown();

        threadWait(testThread, 200);
        System.out.println("Counter thread stopped.");
    }

    @Override
    public String getName() {
        return "Variable thread stop";
    }

    private void threadWait(Thread thread, int millis) {
        do {
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                System.out.print("Interrupt while sleeping...");
            }
        } while (thread.isAlive());
    }
}
