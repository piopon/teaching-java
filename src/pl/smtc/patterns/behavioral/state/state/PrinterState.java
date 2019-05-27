package pl.smtc.patterns.behavioral.state.state;

public interface PrinterState {
    void print(String document);

    void cancel();

    void printoutWait();

    String getStateName();
}
