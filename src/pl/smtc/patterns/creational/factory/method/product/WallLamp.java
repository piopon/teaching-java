package pl.smtc.patterns.creational.factory.method.product;

import pl.smtc.patterns.creational.factory.method.factory.Lamps;

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
