package pl.smtc.patterns.behavioral.state.support;

import pl.smtc.patterns.behavioral.state.context.Printer;
import pl.smtc.patterns.behavioral.state.state.PrinterReady;

public class PrintWorker {
    private Printer parentPrinter;
    private PrintQueue printQueue;

    public PrintWorker(Printer parentPrinter, PrintQueue printQueue) {
        this.parentPrinter = parentPrinter;
        this.printQueue = printQueue;
    }

    public void start() {
        if (printQueue.isEmpty()) {
            parentPrinter.setState(new PrinterReady(parentPrinter));
            return;
        }
        Thread toRun = printQueue.get(0);
        if (!toRun.isAlive()) {
            toRun.start();
        }
    }

    public void stop() {
        printQueue.pop();
        start();
    }

    public void cancel() {
        if (printQueue.isEmpty()) {
            return;
        }
        try {
            printQueue.get(0).interrupt();
            printQueue.get(0).join();
            printQueue.pop();
            start();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public void waitAll() {
        try {
            while (!printQueue.isEmpty()) {
                printQueue.get(0).join();
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
