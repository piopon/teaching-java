package pl.smtc.patterns.behavioral.state.state;

import pl.smtc.patterns.behavioral.state.context.Printer;

public class PrinterReady implements PrinterState {
    private Printer parentPrinter;

    public PrinterReady(Printer parentPrinter) {
        this.parentPrinter = parentPrinter;
    }

    @Override
    public void print(String document) {
        System.out.println("Printer is ready.");
        if (checkInk()) {
            int simTime = parentPrinter.getPagePrintTime();
            parentPrinter.setState(new PrinterBusy(parentPrinter, simTime));
            System.out.println("Print starting...");
            parentPrinter.print(document);
        } else {
            System.out.println("Print aborted... Not enough ink.");
        }
    }

    @Override
    public void cancel() {
        System.out.println("Printer is ready - nothing to cancel...");
    }

    @Override
    public void printoutWait() {
        System.out.println("Printer is ready - no printouts to wait.");
    }

    @Override
    public String getStateName() {
        return "Printer ready";
    }

    private boolean checkInk() {
        System.out.println("Checking ink cassettes:");
        System.out.println(" - black: 100%");
        System.out.println(" - color: 50%");

        return true;
    }
}
