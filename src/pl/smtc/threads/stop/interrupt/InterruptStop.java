package pl.smtc.threads.stop.interrupt;

import pl.smtc.menu.ConsoleExample;

import java.util.Scanner;

public class InterruptStop implements ConsoleExample {
    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.println("> press Enter to interrupt alphabet thread.");

        AlphabetThread alphabetThread = new AlphabetThread(1, false, 100);
        alphabetThread.start();
        in.nextLine();
        alphabetThread.interrupt();

        threadWait(alphabetThread, 200);
        System.out.println("> alphabet thread ended.");
    }

    @Override
    public String getName() {
        return "Interrupt thread";
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
