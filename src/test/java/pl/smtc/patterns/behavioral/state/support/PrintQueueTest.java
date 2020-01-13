package pl.smtc.patterns.behavioral.state.support;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class PrintQueueTest extends BaseTestOut {
    private PrintQueue printQueue;
    private String document = "initial.doc";
    private Runnable runnable = () -> System.out.println("TEST_END");
    private PrintThread thread = new PrintThread(document, 10, runnable);

    @Override
    protected void setUp() {
        printQueue = new PrintQueue();
        printQueue.clearQueue();
        printQueue.push(document, thread);
    }

    @AfterEach
    protected void cleanup() throws InterruptedException {
        thread.join();
        printQueue.clearQueue();
    }

    @Test
    void pushShouldAddNewPrintJobToQueue() {
        String newDocument = "doc.txt";
        Runnable newRunnable = () -> System.out.println("SECOND");
        PrintThread newThread = new PrintThread(newDocument, 10, newRunnable);
        printQueue.push(newDocument, newThread);
        assertFalse(printQueue.isEmpty());
        try {
            printQueue.get(0).start();
            Thread.sleep(25);
            printQueue.get(1).start();
            Thread.sleep(25);
            String output = getOutput();
            assertTrue(output.contains("TEST_END"));
            assertTrue(output.contains("SECOND"));
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void popShouldRemoveFirstPrintJob() {
        assertFalse(printQueue.isEmpty());
        printQueue.pop();
        assertTrue(printQueue.isEmpty());
    }

    @Test
    void isEmptyShouldReturnFalseIfQueueHasAtLeastOneElement() {
        assertFalse(printQueue.isEmpty());
    }

    @Test
    void isEmptyShouldReturnTrueIfQueueHasNoElements() {
        printQueue.pop();
        assertTrue(printQueue.isEmpty());
    }

    @Test
    void getShouldReturnFirstSelectedTaskIndex() {
        assertEquals(printQueue.get(0), thread);
    }
}