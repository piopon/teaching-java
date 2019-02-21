package pl.smtc.threads.comm.basic;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BasicCommTest extends BaseTestInOut {
    private BasicComm basicComm;

    @Override
    protected void setUp() {
        basicComm = new BasicComm();
    }

    @Test
    void executeShouldInvokeBasicCommunicationExample() {
        simulateCommaInput("S, H, Q");
        basicComm.execute();
        String output = getOutput();
        assertTrue(output.contains("> press Q to exit, S to show counter, H to hide it."));
        assertTrue(output.contains("> user inputted: H = hide counter"));
        assertTrue(output.contains("> user inputted: S = show counter"));
        assertTrue(output.contains("> user inputted: Q = quit example"));
    }

    @Test
    void getNameShouldReturnVolatileVariableComm() {
        assertEquals("Volatile variable comm", basicComm.getName());
    }
}