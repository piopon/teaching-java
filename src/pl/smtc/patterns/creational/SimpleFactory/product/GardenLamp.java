package pl.smtc.patterns.creational.SimpleFactory.product;

import pl.smtc.patterns.creational.SimpleFactory.factory.Lamps;

public class GardenLamp implements ILamp {
    private Lamps type;
    private String mounting;
    private String supply;

    public GardenLamp(String mounting, String supply) {
        this.type = Lamps.GARDEN;
        this.mounting = mounting;
        this.supply = supply;
    }

    @Override
    public String getDescription() {
        return type + " LAMP [mount: " + mounting + ", power supply: " + supply + "]";
    }

    @Override
    public Lamps getType() {
        return type;
    }
}
