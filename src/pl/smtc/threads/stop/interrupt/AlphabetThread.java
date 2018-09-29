package pl.smtc.threads.stop.interrupt;

public class AlphabetThread extends Thread {
    private final static char START_CHAR = 'A';
    private final static char STOP_CHAR = 'Z';

    private int id;
    private boolean printout;
    private long quickness;
    private char alpha;

    public AlphabetThread(int id, boolean printout, long quickness) {
        this.id = id;
        this.printout = printout;
        this.quickness = quickness;
    }

    @Override
    public void run() {
        System.out.print("AlphabetThread " + id + " -> run [start]");
        try {
            for (alpha = START_CHAR; alpha <= STOP_CHAR; alpha++) {
                if (printout) {
                    System.out.print(alpha + " ");
                }
                Thread.sleep(quickness);
                alpha = (alpha == STOP_CHAR) ? START_CHAR : alpha;
            }
        } catch (InterruptedException e) {
            System.out.println("AlphabetThread " + id + " -> interrupted!");
            System.out.println("AlphabetThread " + id + " -> last char: " + alpha );
            return;
        }
        System.out.println("AlphabetThread " + id + " -> run [stop]");
    }
}
