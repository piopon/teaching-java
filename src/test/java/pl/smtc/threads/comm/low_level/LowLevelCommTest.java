package pl.smtc.threads.comm.low_level;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class LowLevelCommTest extends BaseTestOut {
    LowLevelComm lowLevelComm;

    @Override
    protected void setUp() {
        lowLevelComm = new LowLevelComm(5, 1, 1, 100);
    }

    @Test
    void executeShouldInvokeLowLevelCommunicationExample() {
        lowLevelComm.execute();
        String output = getOutput();
        assertTrue(output.contains("Sender -> sent item: 1"));
        assertTrue(output.contains("Receiver -> got item: 1"));
    }

    @Test
    void getNameShouldReturnLowLevelCommunication() {
        assertEquals("Low level communication", lowLevelComm.getName());
    }

}