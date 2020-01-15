package pl.smtc.basics.flow.loops;

import pl.smtc.menu.ConsoleExample;

import java.util.Scanner;

public class DoWhileExample implements ConsoleExample {
    @Override
    public void execute() {
        System.out.print("How many loops to execute? ");
        int loopMax = new Scanner(System.in).nextInt();
        int loopNo = 0;
        do {
            System.out.println("Current loop counter: " + (loopNo + 1));
            loopNo++;
        } while (loopNo < loopMax);
    }

    @Override
    public String getName() {
        return "Do-While loop";
    }
}
