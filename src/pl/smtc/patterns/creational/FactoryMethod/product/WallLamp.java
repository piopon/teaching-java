package pl.smtc.patterns.creational.FactoryMethod.product;

import pl.smtc.patterns.creational.FactoryMethod.factory.Lamps;

public class WallLamp extends Lamp {
    public WallLamp(String mounting, String supply) {
        super(mounting, supply);
        type = Lamps.WALL;
    }

    @Override
    public void power(boolean on) {
        System.out.println(type + " LAMP -> POWER " + (on ? "ON" : "OFF"));
    }
}
