package pl.smtc.patterns.behavioral.state.support;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;
import pl.smtc.patterns.behavioral.state.context.Printer;
import pl.smtc.patterns.behavioral.state.state.PrinterReady;

import static org.junit.jupiter.api.Assertions.*;

class PrintWorkerTest extends BaseTestOut {
    private final int simPrintTime = 50;
    private Printer printer = new Printer(simPrintTime);
    private PrintQueue printerQueue = new PrintQueue();
    private PrintWorker printWorker;

    @Override
    protected void setUp() {
        printerQueue.clearQueue();
        printWorker = new PrintWorker(printer, printerQueue);
    }

    @Test
    void startShouldSetPrinterReadyStatusIfPrintQueueIsEmpty() {
        printer.setState(new PrinterReady(printer));
        printWorker.start();
        assertEquals("Printer ready", printer.getStateName());
    }

    @Test
    void startShouldRunFirstPrintTaskIfPrintQueueIsNotEmpty() {
        Thread testThread = new Thread(() -> System.out.println("TEST_THREAD_TEXT"));
        printerQueue.push("doc.txt", testThread);
        try {
            printWorker.start();
            Thread.sleep(25);
            String output = getOutput();
            assertTrue(output.contains("TEST_THREAD_TEXT"));
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        printerQueue.clearQueue();
    }

    @Test
    void stopShouldRemoveTopElementFromPrintQueue() {
        Thread testThread = new Thread(() -> System.out.println("TEST_THREAD_TEXT"));
        printerQueue.push("doc.txt", testThread);
        assertFalse(printerQueue.isEmpty());
        printWorker.start();
        printWorker.stop();
        assertTrue(printerQueue.isEmpty());
        printerQueue.clearQueue();
    }

    @Test
    void cancelShouldDoNothingIfPrintQueueIsEmpty() {
        assertTrue(printerQueue.isEmpty());
        printer.setState(new PrinterReady(printer));
        printWorker.cancel();
        assertEquals("Printer ready", printer.getStateName());
        assertTrue(printerQueue.isEmpty());
    }

    @Test
    void cancelShouldCancelCurrentlyRunningTaskFromPrintQueue() {
        String testDocument = "doc.txt";
        Runnable testRunnable = () -> System.out.println("TEST_THREAD_TEXT");
        PrintThread testThread = new PrintThread(testDocument, 50, testRunnable);
        printerQueue.push(testDocument, testThread);
        printWorker.start();
        printWorker.cancel();
        String output = getOutput();
        assertTrue(output.contains("[PRINT CANCEL] " + testDocument));
        printerQueue.clearQueue();
    }

    @Test
    void waitAllShouldWaitForAllTasksToFinish() {
        String testDocument = "doc.txt";
        Runnable testRunnable = () -> printerQueue.pop();
        PrintThread testThread = new PrintThread(testDocument, 50, testRunnable);
        printerQueue.push(testDocument, testThread);
        assertFalse(printerQueue.isEmpty());
        printWorker.start();
        printWorker.waitAll();
        assertTrue(printerQueue.isEmpty());
        String output = getOutput();
        assertTrue(output.contains("[PRINT START] " + testDocument));
        assertTrue(output.contains("[PRINT STOP] " + testDocument));
    }
}