package pl.smtc.threads.stop.interrupt;

import java.util.concurrent.TimeUnit;

public class AlphabetThread extends Thread {
    private final static char START_CHAR = 'A';
    private final static char STOP_CHAR = 'Z';

    private int id;
    private boolean printout = false;
    private long quickness = 50;
    private long timeout = TimeUnit.MINUTES.toNanos(5);

    public AlphabetThread(int id, boolean printout, long quickness) {
        this.id = id;
        this.printout = printout;
        this.quickness = quickness;
    }

    public AlphabetThread(int id, long timeoutMs) {
        this.id = id;
        this.timeout = TimeUnit.MILLISECONDS.toNanos(timeoutMs);
    }

    @Override
    public void run() {
        System.out.print("AlphabetThread " + id + " -> run [start]");
        char alpha = START_CHAR;
        try {
            long startTime = System.nanoTime();
            for (alpha = START_CHAR; alpha <= STOP_CHAR; alpha++) {
                if (printout) {
                    System.out.print(alpha + " ");
                }
                Thread.sleep(quickness);
                alpha = (alpha == STOP_CHAR) ? START_CHAR : alpha;
                if ((System.nanoTime() - startTime) > timeout) {
                    Thread.currentThread().interrupt();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("AlphabetThread " + id + " -> interrupted!");
            System.out.println("AlphabetThread " + id + " -> last char: " + alpha );
            return;
        }
        System.out.println("AlphabetThread " + id + " -> run [stop]");
    }
}
