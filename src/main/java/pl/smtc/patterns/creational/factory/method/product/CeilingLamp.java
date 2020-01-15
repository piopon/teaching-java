package pl.smtc.patterns.creational.factory.method.product;

import pl.smtc.patterns.creational.factory.method.factory.Lamps;

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
