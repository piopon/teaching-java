package pl.smtc.basics.flow.interrupt;

import pl.smtc.menu.ConsoleExample;

import java.util.Scanner;

public class ReturnExample implements ConsoleExample {
    @Override
    public void execute() {
        System.out.print("How many loops to execute? ");
        int loopMax = new Scanner(System.in).nextInt();
        for (int loopNo = 0; loopNo < loopMax; loopNo++) {
            if (loopNo == loopMax/2) {
                System.out.println("Returning from loop (and method)...");
                return;
            }
            System.out.println("Current loop counter: " + (loopNo + 1));
        }
    }

    @Override
    public String getName() {
        return "Return from loop";
    }
}
