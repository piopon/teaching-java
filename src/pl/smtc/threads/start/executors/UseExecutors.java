package pl.smtc.threads.start.executors;

import pl.smtc.menu.ConsoleExample;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class UseExecutors implements ConsoleExample {

    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.print("How many threads you want to be available: ");
        int threadsNo = in.nextInt();
        System.out.print("How many tasks you want to invoke: ");
        int tasksToDo = in.nextInt();

        ExecutorService executor = Executors.newFixedThreadPool(threadsNo);
        for (int i = 0; i < tasksToDo; i++) {
            executor.submit(new TestThread(i, 10, false));
        }
        executor.shutdown();

        System.out.println("ExecutorService -> " + tasksToDo + " tasks submitted!");
        System.out.println("ExecutorService -> running with " + threadsNo + " threads!");

        try {
            executor.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            System.out.println("ExecutorService -> interrupt!");
        }
        System.out.println("ExecutorService -> all tasks completed!");
    }

    @Override
    public String getName() {
        return "ExecutorService class usage";
    }
}
