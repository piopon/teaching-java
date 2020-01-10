package pl.smtc.threads.sync.semaphore;

import pl.smtc.menu.ConsoleExample;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SemaphoreSync implements ConsoleExample {
    private int simTime;

    public SemaphoreSync() {
        this.simTime = 500;
    }

    public SemaphoreSync(int simTime) {
        this.simTime = simTime;
    }

    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.print("> how many objects will acquire resource? ");
        int receiversNo = in.nextInt();
        try {
            ExecutorService executors = Executors.newCachedThreadPool();
            for (int i = 0; i < receiversNo; i++) {
                executors.submit(() -> SharedResource.getInstance().access(simTime));
            }
            executors.shutdown();
            executors.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("> execution terminated");
        }
        System.out.println("> all " + receiversNo + " receivers used resource.");
    }

    @Override
    public String getName() {
        return "Synchronize with semaphore";
    }
}
