package pl.smtc.patterns.creational.factory.FactoryMethod.product;

import pl.smtc.patterns.creational.factory.FactoryMethod.factory.Lamps;

public class CeilingLamp extends Lamp {
    private String lightSource = "FLUORESCENT";

    public CeilingLamp(String mounting, String supply) {
        super(mounting, supply);
        type = Lamps.CEILING;
    }

    @Override
    public void power(boolean on) {
        System.out.println(type + " " + lightSource + " LAMP -> POWER " + (on ? "ON" : "OFF"));
    }
}
