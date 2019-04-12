package pl.smtc.patterns.structural.facade.computer.software;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class OperatingSystemTest extends BaseTestOut {
    private OperatingSystem operatingSystem;

    @Override
    protected void setUp() {
        operatingSystem = new OperatingSystem("OS");
    }

    @Test
    void startShouldInvokeOsStartProcedure() {
        assertTrue(operatingSystem.start());
        String output = getOutput();
        assertTrue(output.contains("OS started."));
    }

    @Test
    void stopShouldInvokeOsStopProcedure() {
        assertTrue(operatingSystem.stop());
        String output = getOutput();
        assertTrue(output.contains("OS stopped."));
    }
}