package pl.smtc.threads.sync.wait_notify;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class WaitNotifyTest extends BaseTestOut {
    WaitNotify waitNotify;

    @Override
    protected void setUp() {
        waitNotify = new WaitNotify(10);
    }

    @Test
    void executeShouldInvokeWaitAndNotifyExample() {
        waitNotify.execute();
        String output = getOutput();
        assertTrue(output.contains("CommObjectSend -> press Enter to send data. "));
        assertTrue(output.contains("CommObjectReceive -> receive procedure [start]"));
        assertTrue(output.contains("CommObjectReceive -> waiting for data..."));
        assertTrue(output.contains("CommObjectReceive -> data received!"));
        assertTrue(output.contains("CommObjectReceive -> receive procedure [stop]"));
        assertFalse(output.contains("CommObjectReceive -> interrupted!"));
        assertFalse(output.contains("> wait & notify example interrupted!"));
    }

    @Test
    void getNameShouldReturnWaitAndNotifyMethods() {
        assertEquals("Wait and notify methods", waitNotify.getName());
    }
}