package pl.smtc.threads.issues.lockout;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class CommunicationObjectTest extends BaseTestOut {
    CommunicationObject communicationObject;

    @Override
    protected void setUp() {
        communicationObject = new CommunicationObject(5,5,50);
    }

    @Test
    void sendShouldSuccessfullySimulateSendingData() {
        communicationObject.send();
        String output = getOutput();
        System.out.println(output);
        assertTrue(output.contains("CommObjectSend -> send procedure [start]"));
        String expected[] = {"CommObjectSend -> send procedure [stop]", "nested lockout!"};
        assertTrue(containsAny(output, expected));
    }

    @Test
    void receiveShouldSuccessfullySimulateReceivingData() {
        communicationObject.receive();
        String output = getOutput();
        System.out.println(output);
        assertTrue(output.contains("CommObjectReceive -> receive procedure [start]"));
        String expected[] = {"CommObjectReceive -> receive procedure [stop]", "nested lockout!"};
        assertTrue(containsAny(output, expected));
    }

    private boolean containsAny(String current, String... expected) {
        for(String item : expected) {
            if(current.contains(item)) {
                return true;
            }
        }
        return false;
    }
}