package pl.smtc.algorithms.math.bits;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class BitsAlgorithmsTest extends BaseTestInOut {
    private BitsAlgorithms bitsAlgorithms;

    @Override
    protected void setUp() {
        bitsAlgorithms = new BitsAlgorithms();
    }

    @Test
    void executeShouldInvokeBitsAlgorithmsMenu() {
        simulateUserInput("0" + System.lineSeparator());
        bitsAlgorithms.execute();
        String output = getOutput();
        assertTrue(output.contains("1) Bit incrementer"));
        assertTrue(output.contains("2) Check opposite signs"));
        assertTrue(output.contains("3) Gray code generator"));
        assertTrue(output.contains("4) Format converter"));
        assertTrue(output.contains("5) Bits switcher"));
        assertTrue(output.contains("6) Bit subtract"));
    }

    @Test
    void getNameShouldReturnBitsAlgorithmsString() {
        assertEquals("Bits algorithms", bitsAlgorithms.getName());
    }
}