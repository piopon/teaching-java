package pl.smtc.patterns.structural.facade.computer.software;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class BootloaderTest extends BaseTestOut {
    private Bootloader bootloader;

    @Override
    protected void setUp() {
        OperatingSystem testOs = new OperatingSystem("TEST_SYSTEM");
        Kernel testKernel = new Kernel(testOs);
        bootloader = new Bootloader("bootCode", "v1.0", testKernel);
    }

    @Test
    void initializeShouldInvokeBootloaderInitProcedure() {
        bootloader.initialize();
        String output = getOutput();
        assertTrue(output.contains("Loading kernel into memory"));
        assertTrue(output.contains("Copying files, starting daemons, loading system"));
        assertTrue(output.contains("TEST_SYSTEM started."));
    }
}