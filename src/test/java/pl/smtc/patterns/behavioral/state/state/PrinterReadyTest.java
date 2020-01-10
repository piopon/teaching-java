package pl.smtc.patterns.behavioral.state.state;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;
import pl.smtc.patterns.behavioral.state.context.Printer;

import static org.junit.jupiter.api.Assertions.*;

class PrinterReadyTest extends BaseTestOut {
    private PrinterReady printerReady;
    private final Printer mockPrinter = new Printer(50);

    @Override
    protected void setUp() {
        printerReady = new PrinterReady(mockPrinter);
    }

    @Test
    void printShouldInvokePrinterReadyPrintState() {
        printerReady.print("test_doc.txt");
        String output = getOutput();
        assertTrue(output.contains("Printer is ready."));
        assertTrue(output.contains("Checking ink cassettes:"));
        assertTrue(output.contains(" - black: 100%"));
        assertTrue(output.contains(" - color: 50%"));
        assertTrue(output.contains("Print starting..."));
    }

    @Test
    void cancelShouldInvokePrinterReadyCancelState() {
        printerReady.cancel();
        String output = getOutput();
        assertTrue(output.contains("Printer is ready - nothing to cancel..."));
    }

    @Test
    void printoutWaitShouldInvokePrinterReadyWaitState() {
        printerReady.printoutWait();
        String output = getOutput();
        assertTrue(output.contains("Printer is ready - no printouts to wait."));
    }

    @Test
    void getStateNameShouldReturnPrinterReadyString() {
        assertEquals("Printer ready", printerReady.getStateName());
    }
}