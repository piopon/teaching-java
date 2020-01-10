package pl.smtc.patterns.structural.facade.computer.software;

public class Kernel {
    private OperatingSystem system;

    public Kernel(OperatingSystem system) {
        this.system = system;
    }

    public boolean start() {
        System.out.println("Copying files, starting daemons, loading system");
        return system.start();
    }

    public boolean stop() {
        System.out.println("Stopping daemons, unloading files");
        return true;
    }
}
