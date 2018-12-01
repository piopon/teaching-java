package pl.smtc.threads.comm.low_level;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class LowLevelCommTest extends BaseTestInOut {
    LowLevelComm lowLevelComm;

    @Override
    protected void setUp() {
        lowLevelComm = new LowLevelComm(50, 1, 1);
    }

    @Test
    void executeShouldInvokeLowLevelCommunicationExample() {
        simulateUserInput(System.lineSeparator());
        lowLevelComm.execute();
        String output = getOutput();
        assertTrue(output.contains("Sender -> sent item: 1"));
    }

    @Test
    void getNameShouldReturnLowLevelCommunication() {
        assertEquals("Low level communication", lowLevelComm.getName());
    }

}