package pl.smtc.patterns.creational.FactoryMethod.product;

import pl.smtc.patterns.creational.FactoryMethod.factory.Lamps;

public class DesktopLamp extends Lamp {
    private String lightSource = "LED";
    private String lightColour = "WARM 2700K";

    public DesktopLamp(String mounting, String supply) {
        super(mounting, supply);
        type = Lamps.DESKTOP;
    }

    @Override
    public void power(boolean on) {
        String lightKind = lightColour + " " + lightSource;
        System.out.println(type + " LAMP: " + lightKind + " -> POWER " + (on ? "ON" : "OFF"));
    }
}
