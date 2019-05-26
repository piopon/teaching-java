package pl.smtc.patterns.behavioral.state.support;

public class PrintThread extends Thread {
    private Runnable endAction;
    private String document;
    private int printTime;

    public PrintThread(String document, int printTime, Runnable endAction) {
        super(document);
        this.document = document;
        this.printTime = printTime;
        this.endAction = endAction;
    }

    @Override
    public void run() {
        try {
            System.out.println("[PRINT START] " + document);
            Thread.sleep(printTime);
            System.out.println("[PRINT STOP] " + document);
            endAction.run();
        } catch (InterruptedException e) {
            System.out.println("[PRINT CANCEL] " + document);
        }
    }
}
