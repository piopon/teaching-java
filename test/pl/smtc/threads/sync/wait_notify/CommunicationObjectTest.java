package pl.smtc.threads.sync.wait_notify;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class CommunicationObjectTest extends BaseTestInOut {
    CommunicationObject communicationObject;

    @Override
    protected void setUp() {
        communicationObject = new CommunicationObject(10);
    }

    @Test
    void sendShouldSimulateSendingData() {
        simulateUserInput(System.lineSeparator());
        communicationObject.send();
        String output = getOutput();
        assertTrue(output.contains("CommObjectSend -> send procedure [start]"));
        assertTrue(output.contains("CommObjectSend -> press Enter to send data. "));
        assertTrue(output.contains("CommObjectSend -> send procedure [stop]"));
    }

    @Test
    void receiveShouldSimulateReceiveData() {
        communicationObject.receive();
        String output = getOutput();
        assertTrue(output.contains("CommObjectReceive -> receive procedure [start]"));
        assertTrue(output.contains("CommObjectReceive -> waiting for data..."));
        assertTrue(output.contains("CommObjectReceive -> data received!"));
        assertTrue(output.contains("CommObjectReceive -> receive procedure [stop]"));
        assertFalse(output.contains("CommObjectReceive -> interrupted!"));
    }
}