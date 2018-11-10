package pl.smtc.threads.sync.join;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class ProcessDataThreadTest extends BaseTestOut {
    FetchDataThread fetchDataThread;
    ProcessDataThread processDataThread;

    @Override
    protected void setUp() {
        fetchDataThread = new FetchDataThread(10);
        processDataThread = new ProcessDataThread(fetchDataThread, 5, 10);
    }

    @Test
    void runShouldWaitForFetchDataAndProcessItAfterwards() {
        processDataThread.run();
        String output = getOutput();
        assertTrue(output.contains("ProcessDataThread -> run [start]"));
        assertTrue(output.contains("ProcessDataThread -> data received!"));
        assertTrue(output.contains("ProcessDataThread -> processing data..."));
        assertTrue(output.contains("ProcessDataThread -> data ready!"));
        assertTrue(output.contains("ProcessDataThread -> run [stop]"));
    }


}