package pl.smtc.patterns.structural.facade.computer.software;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;
import pl.smtc.patterns.structural.facade.computer.hardware.IBootable;
import pl.smtc.patterns.structural.facade.computer.hardware.IHardware;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BiosTest extends BaseTestOut {
    private Bios bios;

    @Override
    protected void setUp() {
        bios = new Bios();
    }

    @Test
    void selectDevice() {
        TestHardware hdd = new TestHardware("HDD", "* starting hdd", true, "HDD CODE");
        TestHardware ssd = new TestHardware("SSD", "* starting ssd", true, "SSD CODE");
        List<IHardware> testHardware = Arrays.asList(hdd, ssd);
        IBootable device = bios.selectDevice(testHardware, hdd);
        String output = getOutput();
        assertTrue(output.contains("Available devices ["));
        assertTrue(output.contains("SSD"));
        assertTrue(output.contains("HDD"));
        assertTrue(output.contains("]"));
        assertTrue(output.contains("Selecting default one: HDD"));
        assertTrue(device.isBootable());
        assertEquals("HDD CODE", device.getBootCode());
    }

    @Test
    void getBootCode() {
        String expected = "TEST BOOT CODE FROM IBOOTABLE";
        String result = bios.getBootCode(new IBootable() {
            @Override
            public boolean isBootable() {
                return true;
            }

            @Override
            public String getBootCode() {
                return expected;
            }
        });
        assertEquals(expected, result);
    }

    private class TestHardware implements IHardware, IBootable {
        private String name;
        private String init;
        private boolean bootable;
        private String bootCode;

        TestHardware(String name, String init, boolean bootable, String bootCode) {
            this.name = name;
            this.init = init;
            this.bootable = bootable;
            this.bootCode = bootCode;
        }

        @Override
        public boolean isBootable() {
            return bootable;
        }

        @Override
        public String getBootCode() {
            return bootCode;
        }

        @Override
        public void init() {
            System.out.println(init);
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String toString() { return getName(); }
    }

}