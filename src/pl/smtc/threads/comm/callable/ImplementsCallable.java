package pl.smtc.threads.comm.callable;

import pl.smtc.menu.ConsoleExample;

import java.util.Scanner;
import java.util.concurrent.FutureTask;

public class ImplementsCallable implements ConsoleExample {
    @Override
    public void execute() {
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("> press Enter to start thread.");
            in.nextLine();

            FutureTask<Integer> testThread = new FutureTask<>(new MyCallable(5000));
            testThread.run();

            System.out.println("> thread finished - got result: " + testThread.get());
        } catch (Exception e) {
            System.out.println("> example interrupted!");
        }
    }

    @Override
    public String getName() {
        return "Implement Callable interface";
    }

}
