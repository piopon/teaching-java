package pl.smtc.patterns.behavioral.state.state;

import pl.smtc.patterns.behavioral.state.context.Printer;
import pl.smtc.patterns.behavioral.state.support.PrintQueue;
import pl.smtc.patterns.behavioral.state.support.PrintThread;
import pl.smtc.patterns.behavioral.state.support.PrintWorker;

import java.util.ArrayList;
import java.util.List;

public class PrinterBusy implements PrinterState {
    private PrintQueue printQueue = new PrintQueue();
    private PrintWorker printWorker;
    private int printSimTime;

    public PrinterBusy(Printer parentPrinter, int printSimTime) {
        printWorker = new PrintWorker(parentPrinter, printQueue);
        this.printSimTime = printSimTime;
    }

    @Override
    public void print(String document) {
        System.out.println("Print in progress: " + document);
        Thread printAction = new PrintThread(document, printSimTime, () -> printWorker.stop());
        printQueue.push(document, printAction);
        printWorker.start();
    }

    @Override
    public void cancel() {
        System.out.println("Print in progress - cancelling print.");
        printWorker.cancel();
    }

    @Override
    public void printoutWait() {
        System.out.println("Print in progress - waiting for all prints to end.");
        printWorker.waitAll();
    }

    @Override
    public String getStateName() {
        return "Printer busy";
    }
}
