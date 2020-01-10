package pl.smtc.patterns.structural.facade.computer.hardware;

public class GraphicsCard implements IHardware, IBootable {
    @Override
    public boolean isBootable() {
        return false;
    }

    @Override
    public String getBootCode() {
        return "ERROR - DEVICE NOT BOOTABLE";
    }

    @Override
    public void init() {
        System.out.println(" * Powering up, initializing drivers, benchmarking");
    }

    @Override
    public String getName() {
        return "GRAPHICS CARD";
    }

    @Override
    public String toString() {
        return getName();
    }
}
