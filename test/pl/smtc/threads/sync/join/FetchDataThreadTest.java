package pl.smtc.threads.sync.join;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class FetchDataThreadTest extends BaseTestOut {
    FetchDataThread fetchDataThread;

    @Override
    protected void setUp() {
        fetchDataThread = new FetchDataThread(10);
    }

    @Test
    void runShouldSimulateDownloadingData() {
        fetchDataThread.run();
        String output = getOutput();
        assertTrue(output.contains("FetchDataThread -> run [start]"));
        assertTrue(output.contains("FetchDataThread -> downloading data..."));
        assertTrue(output.contains("FetchDataThread -> data downloaded"));
        assertTrue(output.contains("FetchDataThread -> run [stop]"));
    }


}