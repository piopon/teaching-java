package pl.smtc.patterns.structural.facade.computer.hardware;

public class DvdRomDrive implements IHardware, IBootable {
    @Override
    public boolean isBootable() {
        return true;
    }

    @Override
    public String getBootCode() {
        return "BOOT CODE FOR DVD-ROM DRIVE";
    }

    @Override
    public void init() {
        System.out.println(" * Power up, checking laser, setting zero position");
    }

    @Override
    public String getName() {
        return "DVD-ROM DRIVE";
    }

    @Override
    public String toString() {
        return getName();
    }
}
