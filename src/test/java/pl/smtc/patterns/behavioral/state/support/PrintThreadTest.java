package pl.smtc.patterns.behavioral.state.support;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class PrintThreadTest extends BaseTestOut {
    private PrintThread printThread;
    private final String document = "doc>text.txt";
    private final String endPrint = "endAction TEXT";

    @Override
    protected void setUp() {
        Runnable runnable = () -> System.out.println(endPrint);
        printThread = new PrintThread(document, 10, runnable);
    }

    @AfterEach
    private void cleanTest() throws InterruptedException {
        if (printThread.isAlive()) {
            printThread.join();
        }
    }

    @Test
    void runShouldInvokePrintThreadStartAndEndActionRunnable() {
        printThread.run();
        String output = getOutput();
        assertTrue(output.contains("[PRINT START] " + document));
        assertTrue(output.contains("[PRINT STOP] " + document));
        assertTrue(output.contains("endAction TEXT"));
    }
}