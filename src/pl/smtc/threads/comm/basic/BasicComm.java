package pl.smtc.threads.comm.basic;

import pl.smtc.menu.ConsoleExample;

import java.util.Scanner;

public class BasicComm implements ConsoleExample {

    @Override
    public void execute() {
        CountThread testThread = new CountThread(1, true);
        testThread.start();
        System.out.println("> press Q to exit, S to show counter, H to hide it.");
        String userInput = "";
        Scanner in = new Scanner(System.in);
        while (!userInput.equalsIgnoreCase("Q")) {
            userInput = in.nextLine();
            executeThreadAction(userInput.toUpperCase(), testThread);
        }
        threadWait(testThread, 200);
    }

    @Override
    public String getName() {
        return "Volatile variable comm";
    }

    private void executeThreadAction(String action, CountThread thread) {
        switch (action) {
            case "Q":
                System.out.println("> user inputted: " + action + " = quit example");
                thread.shutdown();
                break;
            case "S":
                System.out.println("> user inputted: " + action + " = show counter");
                thread.counterOn();
                break;
            case "H":
                System.out.println("> user inputted: " + action + " = hide counter");
                thread.counterOff();
                break;
            default:
                System.out.println("> unknown action [" + action + "]...");
        }
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
