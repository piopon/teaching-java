package pl.smtc.patterns.structural.facade.computer.software;

public class OperatingSystem {
    private String name;

    public OperatingSystem(String name) {
        this.name = name;
    }

    public boolean start() {
        System.out.println(name + " started.");
        return true;
    }

    public boolean stop() {
        System.out.println(name + " stopped.");
        return true;
    }
}
