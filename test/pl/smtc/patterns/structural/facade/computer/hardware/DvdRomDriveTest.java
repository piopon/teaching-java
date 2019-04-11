package pl.smtc.patterns.structural.facade.computer.hardware;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class DvdRomDriveTest extends BaseTestOut {
    private DvdRomDrive dvdRomDrive;

    @Override
    protected void setUp() {
        dvdRomDrive = new DvdRomDrive();
    }

    @Test
    void isBootableShouldReturnTrue() {
        assertTrue(dvdRomDrive.isBootable());
    }

    @Test
    void getBootCodeShouldReturnDvdBootCode() {
        assertEquals("BOOT CODE FOR DVD-ROM DRIVE", dvdRomDrive.getBootCode());
    }

    @Test
    void initShouldInvokeInitializationProcedure() {
        dvdRomDrive.init();
        String output = getOutput();
        assertTrue(output.contains(" * Power up, checking laser, setting zero position"));
    }

    @Test
    void getNameShouldReturnDvdRomDriveString() {
        assertEquals("DVD-ROM DRIVE", dvdRomDrive.getName());
    }

    @Test
    void toStringShouldReturnDvdRomDriveString() {
        assertEquals("DVD-ROM DRIVE", dvdRomDrive.toString());
    }
}