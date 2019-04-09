package pl.smtc.patterns.structural.facade.computer;

import pl.smtc.patterns.structural.facade.computer.software.Bios;
import pl.smtc.patterns.structural.facade.computer.software.Bootloader;
import pl.smtc.patterns.structural.facade.computer.software.Kernel;
import pl.smtc.patterns.structural.facade.computer.software.OperatingSystem;
import pl.smtc.patterns.structural.facade.computer.hardware.*;

import java.util.Arrays;
import java.util.List;

public class Computer {
    private List<IHardware> hardware = Arrays.asList(new HardDiskDrive(), new DvdRomDrive(), new GraphicsCard());
    private OperatingSystem os = new OperatingSystem("Ubuntu 18.04LTS");
    private Kernel kernel = new Kernel(os);

    public void turnOn() {
        System.out.println("-------------------------------");
        System.out.println("COMPUTER - POWER ON");
        Bios bios = new Bios();
        System.out.println("Initialize all devices");
        hardware.forEach(IHardware::init);
        System.out.println("Select boot device");
        IBootable bootDevice = bios.selectDevice(hardware, hardware.get(0));
        String bootCode = bios.getBootCode(bootDevice);
        System.out.println("Running loader");
        Bootloader bootloader = new Bootloader(bootCode, "V1.3.3", kernel);
        bootloader.initialize();
        System.out.println("COMPUTER - READY TO WORK");
        System.out.println("-------------------------------");
    }

    public void turnOff() {
        System.out.println("-------------------------------");
        System.out.println("COMPUTER - POWER OFF");
        os.stop();
        kernel.stop();
        System.out.println("COMPUTER - SHUTDOWN");
        System.out.println("-------------------------------");
    }
}
