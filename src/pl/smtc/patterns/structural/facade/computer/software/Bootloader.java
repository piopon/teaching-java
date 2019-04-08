package pl.smtc.patterns.structural.facade.computer.software;

public class Bootloader {
    private Kernel kernel;

    public Bootloader(String bootCode, String version, Kernel kernel) {
        this.kernel = kernel;
        System.out.println("Starting bootloader " + version + " from " + bootCode);
    }

    public void initialize() {
        System.out.println("Loading kernel into memory");
        kernel.start();
    }
}
