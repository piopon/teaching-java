package pl.smtc.patterns.structural.facade.computer.hardware;

public class HardDiskDrive implements IHardware, IBootable {
    @Override
    public boolean isBootable() {
        return true;
    }

    @Override
    public String getBootCode() {
        return "BOOT CODE FOR HARD DISK";
    }

    @Override
    public void init() {
        System.out.println(" * Powering up disk and checking disk integrity");
    }

    @Override
    public String getName() {
        return "HD DRIVE";
    }

    @Override
    public String toString() {
        return getName();
    }
}
