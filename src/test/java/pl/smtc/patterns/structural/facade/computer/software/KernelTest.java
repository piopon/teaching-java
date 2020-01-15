package pl.smtc.patterns.structural.facade.computer.software;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class KernelTest extends BaseTestOut {
    private Kernel kernel;

    @Override
    protected void setUp() {
        OperatingSystem testOs = new OperatingSystem("OS_TEST");
        kernel = new Kernel(testOs);
    }

    @Test
    void startShouldInvokeKernelStartProcedure() {
        assertTrue(kernel.start());
        String output = getOutput();
        assertTrue(output.contains("Copying files, starting daemons, loading system"));
        assertTrue(output.contains("OS_TEST started."));
    }

    @Test
    void stopShouldInvokeKernelStopProcedure() {
        assertTrue(kernel.stop());
        String output = getOutput();
        assertTrue(output.contains("Stopping daemons, unloading files"));
    }
}