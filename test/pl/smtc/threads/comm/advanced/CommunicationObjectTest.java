package pl.smtc.threads.comm.advanced;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class CommunicationObjectTest extends BaseTestOut {
    CommunicationObject communicationObject;

    @Override
    protected void setUp() {
        communicationObject = new CommunicationObject(3,1,1,1);
    }

    @Test
    void sendShouldSendValueOne() {
        communicationObject.send();
        String output = getOutput();
        assertTrue(output.contains("CommObjectSend -> send: 1"));
    }

    @Test
    void receiveShouldReceiveValueOne() {
        communicationObject.send();
        communicationObject.receive();
        String output = getOutput();
        assertTrue(output.contains("CommObjectSend -> receive: 1"));
    }
}