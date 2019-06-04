package pl.smtc.patterns.behavioral.state.state;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;
import pl.smtc.patterns.behavioral.state.context.Printer;

import static org.junit.jupiter.api.Assertions.*;

class PrinterBusyTest extends BaseTestOut {
    private PrinterBusy printerBusy;
    private final int printSimTime = 50;
    private final Printer mockPrinter = new Printer(printSimTime);

    @Override
    protected void setUp() {
        printerBusy = new PrinterBusy(mockPrinter, printSimTime);
    }

    @Test
    void printShouldInvokePrinterBusyPrintState() {
        String testDocument = "test_doc.txt";
        printerBusy.print(testDocument);
        String output = getOutput();
        assertTrue(output.contains("Print in progress: " + testDocument));
        assertTrue(output.contains("Added to print queue: " + testDocument));
    }

    @Test
    void cancelShouldInvokePrinterBusyCancelState() {
        String testDocument = "test_doc.txt";
        printerBusy.print(testDocument);
        printerBusy.cancel();
        String output = getOutput();
        assertTrue(output.contains("Print in progress - cancelling print."));
        assertTrue(output.contains("[PRINT CANCEL] " + testDocument));
    }

    @Test
    void printoutWaitShouldInvokePrinterBusyWaitState() {
        String testDocument = "test_doc.txt";
        printerBusy.print(testDocument);
        printerBusy.printoutWait();
        String output = getOutput();
        assertTrue(output.contains("Print in progress - waiting for all prints to end."));
        assertTrue(output.contains("[PRINT STOP] " + testDocument));
    }

    @Test
    void getStateNameShouldReturnPrinterBusyString() {
        assertEquals("Printer busy", printerBusy.getStateName());
    }
}