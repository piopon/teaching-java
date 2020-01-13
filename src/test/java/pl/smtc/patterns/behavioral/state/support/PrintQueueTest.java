package pl.smtc.patterns.behavioral.state.support;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class PrintQueueTest extends BaseTestOut {
    private final static int PRINT_TIME = 5;
    private final static int PRINT_WAIT = 50;
    private PrintQueue printQueue;
    private String document = "print_queue_test.doc";
    private Runnable runnable = () -> System.out.println("TEST_END");
    private PrintThread thread = new PrintThread(document, PRINT_TIME, runnable);

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
        String newDocument = "doc_from_print_queue.txt";
        Runnable newRunnable = () -> System.out.println("SECOND");
        PrintThread newThread = new PrintThread(newDocument, 10, newRunnable);
        printQueue.push(newDocument, newThread);
        assertFalse(printQueue.isEmpty());
        try {
            printQueue.get(0).start();
            Thread.sleep(PRINT_WAIT);
            printQueue.get(1).start();
            Thread.sleep(PRINT_WAIT);
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