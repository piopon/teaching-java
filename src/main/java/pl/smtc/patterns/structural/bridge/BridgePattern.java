package pl.smtc.patterns.structural.bridge;

import pl.smtc.menu.ConsoleExample;
import pl.smtc.patterns.structural.bridge.abstraction.*;
import pl.smtc.patterns.structural.bridge.abstraction.Character;
import pl.smtc.patterns.structural.bridge.implementor.Bionic;
import pl.smtc.patterns.structural.bridge.implementor.Pistol;
import pl.smtc.patterns.structural.bridge.implementor.Rifle;

public class BridgePattern implements ConsoleExample {
    @Override
    public void execute() {
        Character hero = new Soldier("HERO");
        Character sidekick = new Engineer("SIDEKICK");
        Character villain = new Infiltrator("VILLAIN");

        hero.move();
        hero.attack(new Rifle(70));
        villain.attack(new Pistol(30));
        sidekick.move();
        sidekick.attack(new Bionic(50));
    }

    @Override
    public String getName() {
        return "Bridge pattern";
    }
}
