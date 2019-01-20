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
    }

    @Test
    void getNameShouldReturnBitsAlgorithmsString() {
        assertEquals("Bits algorithms", bitsAlgorithms.getName());
    }
}