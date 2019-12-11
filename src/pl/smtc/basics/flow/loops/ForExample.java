package pl.smtc.basics.flow.loops;

import pl.smtc.menu.ConsoleExample;

import java.util.Scanner;

public class ForExample implements ConsoleExample {
    @Override
    public void execute() {
        System.out.print("How many loops to execute? ");
        int loopMax = new Scanner(System.in).nextInt();
        for (int loopNo = 0; loopNo < loopMax; loopNo++) {
            System.out.println("Current loop counter: " + loopNo + 1);
        }
    }

    @Override
    public String getName() {
        return "For loop";
    }
}
