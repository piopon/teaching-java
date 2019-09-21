package pl.smtc.patterns.creational.factory.FactoryMethod.product;

import pl.smtc.patterns.creational.factory.FactoryMethod.factory.Lamps;

public class GardenLamp extends Lamp {
    private double storedEnergy = 100.0;

    public GardenLamp(String mounting, String supply) {
        super(mounting, supply);
        type = Lamps.GARDEN;
    }

    @Override
    public void power(boolean on) {
        String energyStatus = "STORED ENERGY: " + storedEnergy + "%";
        if (storedEnergy > 0.0) {
            System.out.println(type + " LAMP: " + (on ? "ON" : "OFF") + " [" + energyStatus + "]");
            storedEnergy -= on ? 25.0 : 0.0;
        } else {
            System.out.println("NO LIGHT - " + energyStatus);
        }
    }
}
