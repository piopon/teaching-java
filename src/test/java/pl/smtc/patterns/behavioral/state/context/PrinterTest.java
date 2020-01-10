package pl.smtc.patterns.behavioral.state.context;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;
import pl.smtc.patterns.behavioral.state.state.PrinterReady;

import static org.junit.jupiter.api.Assertions.*;

class PrinterTest extends BaseTestOut {
    private final int simPagePrintTime = 50;
    private Printer testPrinter;

    @Override
    protected void setUp() {
        testPrinter = new Printer(simPagePrintTime);
    }

    @Test
    void initializeShouldInitPrinterState() {
        assertFalse(testPrinter.state.isPresent());
        testPrinter.initialize();
        assertTrue(testPrinter.state.isPresent());
    }

    @Test
    void getPagePrintTimeShouldReturnPrintTime() {
        assertEquals(simPagePrintTime, testPrinter.getPagePrintTime());
    }

    @Test
    void setStateShouldUpdatePrinterState() {
        PrinterReady printerReadyState = new PrinterReady(testPrinter);
        testPrinter.setState(printerReadyState);
        assertEquals(printerReadyState, testPrinter.state.get());
    }

    @Test
    void printShouldInvokePrintMethodOfCurrentState() {
        testPrinter.setState(new PrinterReady(testPrinter));
        testPrinter.print("test_doc.txt");
        String output = getOutput();
        assertTrue(output.contains("Printer is ready."));
        assertTrue(output.contains("Checking ink cassettes:"));
        assertTrue(output.contains(" - black: 100%"));
        assertTrue(output.contains(" - color: 50%"));
        assertTrue(output.contains("Print starting..."));
    }

    @Test
    void cancelShouldInvokeCancelMethodOfCurrentState() {
        testPrinter.setState(new PrinterReady(testPrinter));
        testPrinter.cancel();
        String output = getOutput();
        assertTrue(output.contains("Printer is ready - nothing to cancel..."));
    }

    @Test
    void waitForAllPrintsShouldInvokeWaitMethodOfCurrentState() {
        testPrinter.setState(new PrinterReady(testPrinter));
        testPrinter.waitForAllPrints();
        String output = getOutput();
        assertTrue(output.contains("Printer is ready - no printouts to wait."));
    }
}