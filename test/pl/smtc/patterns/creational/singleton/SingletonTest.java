package pl.smtc.patterns.creational.singleton;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class SingletonTest extends BaseTestInOut {
    private Singleton singleton;

    @Override
    protected void setUp() {
        singleton = new Singleton();
    }

    @Test
    void executeShouldInvokeSingletonPatternExample() {
        simulateCommaInput("TEST, RESOURCE, Q");
        singleton.execute();
        String output = getOutput();
        assertTrue(output.contains("Select option [LOGGER, RESOURCE, Q]"));
        assertTrue(output.contains("Unknown command: TEST"));
        assertTrue(output.contains("Opening remote resource [ssh@10.0.168.1] ... OK"));
        assertTrue(output.contains("Sending: data1 to resource [ssh@10.0.168.1] ... OK"));
        assertTrue(output.contains("Closing remote resource [ssh@10.0.168.1] ... OK"));
        assertTrue(output.contains("ERROR. Cannot send data: data3 - connection closed."));
    }

    @Test
    void getNameShouldReturnSingletonPatternString() {
        assertEquals("Singleton pattern", singleton.getName());
    }

    @Test
    void checkResourceShouldInvokeRemoteResourceExample() {
        singleton.checkResource();
        String output = getOutput();
        assertTrue(output.contains("Opening remote resource [ssh@10.0.168.1] ... OK"));
        assertTrue(output.contains("Sending: data1 to resource [ssh@10.0.168.1] ... OK"));
        assertTrue(output.contains("Sending: data2 to resource [ssh@10.0.168.1] ... OK"));
        assertTrue(output.contains("Closing remote resource [ssh@10.0.168.1] ... OK"));
        assertTrue(output.contains("ERROR. Cannot send data: data3 - connection closed."));
    }

    @Test
    void checkLoggerShouldInvokeApplicationLoggerExample() {
        singleton.checkLogger();
        String output = getOutput();
        assertTrue(output.contains("INFO: info1"));
        assertTrue(output.contains("WARNING: warning2"));
        assertTrue(output.contains("INFO: info3"));
        assertTrue(output.contains("ERROR: error4"));
        assertTrue(output.contains("INFO: info5"));
        assertTrue(output.contains("WARNING: warning6"));
        assertTrue(output.contains("WARNING: warning7"));
        assertTrue(output.contains("INFO: info8"));
        assertTrue(output.contains("ERROR: error10"));
        assertTrue(output.contains("INFO: info9"));
        assertTrue(output.contains("INFO: info11"));
        assertTrue(output.contains("1) WARNING: warning2"));
        assertTrue(output.contains("5) WARNING: warning6"));
        assertTrue(output.contains("10) INFO: info11"));
    }
}