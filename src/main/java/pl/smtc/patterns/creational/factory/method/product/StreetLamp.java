package pl.smtc.patterns.creational.factory.method.product;

import pl.smtc.patterns.creational.factory.method.factory.Lamps;

public class StreetLamp extends Lamp {
    public StreetLamp(String mounting, String supply) {
        super(mounting, supply);
        type = Lamps.STREET;
    }

    @Override
    public void power(boolean on) {
        String dimStatus = on ? "WARMING UP" : "COOLING DOWN";
        System.out.println(type + " LAMP: POWER " + (on ? "ON" : "OFF") + " = " + dimStatus + "...");
    }
}
