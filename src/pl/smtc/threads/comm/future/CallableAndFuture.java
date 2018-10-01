package pl.smtc.threads.comm.future;

import pl.smtc.menu.ConsoleExample;

import java.util.Scanner;
import java.util.concurrent.*;

public class CallableAndFuture implements ConsoleExample {
    @Override
    public void execute() {
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("> press Enter to start thread.");
            in.nextLine();

            ExecutorService executorService = Executors.newCachedThreadPool();
            Future<Integer> future = executorService.submit(new MyCallable(5000, 3000));
            executorService.shutdown();
            executorService.awaitTermination(1,TimeUnit.MINUTES);

            System.out.println("> thread finished - result: " + future.get());
        } catch (InterruptedException e) {
            System.out.println("> example interrupted!");
        } catch (ExecutionException e) {
            System.out.println("> callable exception: " + e.getMessage());
        }
    }

    @Override
    public String getName() {
        return "Callable and Future";
    }
}
