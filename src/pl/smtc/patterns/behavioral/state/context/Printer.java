package pl.smtc.patterns.behavioral.state.context;

import pl.smtc.patterns.behavioral.state.state.PrinterReady;
import pl.smtc.patterns.behavioral.state.state.PrinterState;

import java.util.Optional;

public class Printer {
    protected Optional<PrinterState> state = Optional.empty();
    private int pagePrintTime;

    public Printer() {
        this.pagePrintTime = 10_000;
    }

    public Printer(int pagePrintTime) {
        this.pagePrintTime = pagePrintTime;
    }

    public void initialize() {
        setState(new PrinterReady(this));
    }

    public int getPagePrintTime() {
        return pagePrintTime;
    }

    public void setState(PrinterState newState) {
        state = Optional.of(newState);
    }

    public String getStateName() {
        return (state.isPresent()) ? state.get().getStateName() : "Unknowns";
    }

    public void print(String document) {
        state.ifPresent(state -> state.print(document));
    }

    public void cancel() {
        state.ifPresent(PrinterState::cancel);
    }

    public void waitForAllPrints() {
        state.ifPresent(PrinterState::printoutWait);
    }
}
