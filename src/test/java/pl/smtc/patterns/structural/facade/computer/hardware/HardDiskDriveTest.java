package pl.smtc.patterns.structural.facade.computer.hardware;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class HardDiskDriveTest extends BaseTestOut {
    private HardDiskDrive hardDiskDrive;

    @Override
    protected void setUp() {
        hardDiskDrive = new HardDiskDrive();
    }

    @Test
    void isBootableShouldReturnTrue() {
        assertTrue(hardDiskDrive.isBootable());
    }

    @Test
    void getBootCodeShouldReturnHddBootCode() {
        assertEquals("BOOT CODE FOR HARD DISK", hardDiskDrive.getBootCode());
    }

    @Test
    void initShouldInvokeInitializationProcedure() {
        hardDiskDrive.init();
        String output = getOutput();
        assertTrue(output.contains(" * Powering up disk and checking disk integrity"));
    }

    @Test
    void getNameShouldReturnHdDriveString() {
        assertEquals("HD DRIVE", hardDiskDrive.getName());
    }

    @Test
    void toStringShouldReturnHdDriveString() {
        assertEquals("HD DRIVE", hardDiskDrive.getName());
    }
}