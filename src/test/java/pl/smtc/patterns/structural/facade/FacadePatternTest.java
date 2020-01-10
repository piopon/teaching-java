package pl.smtc.patterns.structural.facade;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class FacadePatternTest extends BaseTestOut {
    private FacadePattern facadePattern;

    @Override
    protected void setUp() {
        facadePattern = new FacadePattern();
    }

    @Test
    void executeShouldInvokeFacadePatternExample() {
        facadePattern.execute();
        String output = getOutput();
        assertTrue(output.contains("-------------------------------"));
        assertTrue(output.contains("COMPUTER - POWER ON"));
        assertTrue(output.contains("Starting BIOS"));
        assertTrue(output.contains("Initialize all devices"));
        assertTrue(output.contains("* Powering up disk and checking disk integrity"));
        assertTrue(output.contains("* Power up, checking laser, setting zero position"));
        assertTrue(output.contains("* Powering up, initializing drivers, benchmarking"));
        assertTrue(output.contains("Select boot device"));
        assertTrue(output.contains("Available devices [HD DRIVE, DVD-ROM DRIVE, GRAPHICS CARD]"));
        assertTrue(output.contains("Selecting default one: HD DRIVE"));
        assertTrue(output.contains("Running loader"));
        assertTrue(output.contains("Starting bootloader V1.3.3 from BOOT CODE FOR HARD DISK"));
        assertTrue(output.contains("Loading kernel into memory"));
        assertTrue(output.contains("Copying files, starting daemons, loading system"));
        assertTrue(output.contains("Ubuntu 18.04LTS started."));
        assertTrue(output.contains("COMPUTER - READY TO WORK"));
        assertTrue(output.contains("Doing some work on my computer"));
        assertTrue(output.contains("COMPUTER - POWER OFF"));
        assertTrue(output.contains("Ubuntu 18.04LTS stopped."));
        assertTrue(output.contains("Stopping daemons, unloading files"));
        assertTrue(output.contains("COMPUTER - SHUTDOWN"));
    }

    @Test
    void getNameShouldReturnFacadePatternString() {
        assertEquals("Facade pattern", facadePattern.getName());
    }
}