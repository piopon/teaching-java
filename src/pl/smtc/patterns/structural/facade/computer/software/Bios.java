package pl.smtc.patterns.structural.facade.computer.software;

import pl.smtc.patterns.structural.facade.computer.hardware.IBootable;
import pl.smtc.patterns.structural.facade.computer.hardware.IHardware;

import java.util.List;

public class Bios {
    public Bios() {
        System.out.println("Starting BIOS");
    }

    public IBootable selectDevice(List<IHardware> devices, IHardware defaultDevice) {
        System.out.println("Available devices " + devices);
        System.out.println("Selecting default one: " + defaultDevice.getName());
        return (IBootable) devices.get(0);
    }

    public String getBootCode(IBootable bootable) throws IllegalArgumentException {
        if (bootable.isBootable()) {
            return bootable.getBootCode();
        }
        throw new IllegalArgumentException("Selected device is not bootable");
    }
}
