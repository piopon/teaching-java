package pl.smtc.threads.issues.deadlock;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class CommunicationObjectTest extends BaseTestOut {
    CommunicationObject commObject;

    @Override
    protected void setUp() {
        commObject = new CommunicationObject(10,10,50);
    }

    @Test
    void sendShouldSimulateSendTaskWithDeadlock() {
        commObject.send();
        String output = getOutput();
        assertTrue(output.contains("CommObjectSend -> wait LOCK 1"));
        assertTrue(output.contains("CommObjectSend-> got LOCK 1"));
        assertTrue(output.contains("CommObjectSend -> sim work time:"));
        assertTrue(output.contains("CommObjectSend -> wait LOCK 2"));
        assertTrue(output.contains("CommObjectSend-> got LOCK 2"));
    }

    @Test
    void receiveShouldSimulateReceiveTaskWithDeadlock() {
        commObject.receive();
        String output = getOutput();
        assertTrue(output.contains("CommObjectReceive -> wait LOCK 1"));
        assertTrue(output.contains("CommObjectReceive-> got LOCK 1"));
        assertTrue(output.contains("CommObjectReceive -> sim work time:"));
        assertTrue(output.contains("CommObjectReceive -> wait LOCK 2"));
        assertTrue(output.contains("CommObjectReceive-> got LOCK 2"));
    }
}