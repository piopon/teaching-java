package pl.smtc.basics.flow.loops;

import pl.smtc.menu.ConsoleExample;

import java.util.Scanner;

public class WhileExample implements ConsoleExample {
    @Override
    public void execute() {
        System.out.print("How many loops to execute? ");
        int loopMax = new Scanner(System.in).nextInt();
        int loopNo = 0;
        while (loopNo < loopMax) {
            System.out.println("Current loop counter: " + (loopNo + 1));
            loopNo++;
        }
    }

    @Override
    public String getName() {
        return "While loop";
    }
}
