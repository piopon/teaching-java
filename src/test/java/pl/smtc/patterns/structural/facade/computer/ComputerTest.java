package pl.smtc.patterns.structural.facade.computer;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest extends BaseTestOut {
    private Computer computer;

    @Override
    protected void setUp() {
        computer = new Computer();
    }

    @Test
    void turnOnShouldInvokePowerOnProcedure() {
        computer.turnOn();
        String output = getOutput();
        assertTrue(output.contains("Starting BIOS"));
        assertTrue(output.contains("Initialize all devices"));
        assertTrue(output.contains("Available devices [HD DRIVE, DVD-ROM DRIVE, GRAPHICS CARD]"));
        assertTrue(output.contains("Selecting default one: HD DRIVE"));
        assertTrue(output.contains("Starting bootloader V1.3.3 from BOOT CODE FOR HARD DISK"));
        assertTrue(output.contains("Loading kernel into memory"));
        assertTrue(output.contains("Copying files, starting daemons, loading system"));
        assertTrue(output.contains("Ubuntu 18.04LTS started."));
    }

    @Test
    void turnOffShouldInvokePowerOffProcedure() {
        computer.turnOff();
        String output = getOutput();
        assertTrue(output.contains("Ubuntu 18.04LTS stopped."));
        assertTrue(output.contains("Stopping daemons, unloading files"));
    }

}