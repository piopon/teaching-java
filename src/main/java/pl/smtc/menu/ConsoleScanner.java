package pl.smtc.menu;

import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.*;

public class ConsoleScanner {
    private Scanner in;
    private ExecutorService executor;
    private boolean userInputted = false;
    private String userInput = "";

    public ConsoleScanner(InputStream input) {
        this.in = new Scanner(input);
        executor = Executors.newSingleThreadExecutor(runnable -> {
            Thread t = new Thread(runnable);
            t.setDaemon(true);
            return t;
        });
    }

    public void waitForInput() {
        waitForInput(Integer.MAX_VALUE);
    }

    public boolean waitForInput(int timeout) {
        try {
            Future<Boolean> hasNextLine = executor.submit(new GetNextLine());
            userInputted = hasNextLine.get(timeout, TimeUnit.MILLISECONDS);
            userInput = in.nextLine();
            return userInputted;
        } catch (TimeoutException | InterruptedException | ExecutionException e) {
            return false;
        }
    }

    public String getLastString() throws NoSuchElementException {
        if (userInputted) {
            userInputted = false;
            return userInput;
        } else {
            throw new NoSuchElementException("ERROR! No user input present!");
        }
    }

    private class GetNextLine implements Callable<Boolean> {
        @Override
        public Boolean call() {
            return in.hasNextLine();
        }
    }
}
