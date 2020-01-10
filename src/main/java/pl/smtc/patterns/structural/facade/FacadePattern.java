package pl.smtc.patterns.structural.facade;

import pl.smtc.menu.ConsoleExample;
import pl.smtc.patterns.structural.facade.computer.Computer;

public class FacadePattern implements ConsoleExample {
    @Override
    public void execute() {
        Computer pc = new Computer();
        pc.turnOn();
        System.out.println("Doing some work on my computer");
        pc.turnOff();
    }

    @Override
    public String getName() {
        return "Facade pattern";
    }
}
