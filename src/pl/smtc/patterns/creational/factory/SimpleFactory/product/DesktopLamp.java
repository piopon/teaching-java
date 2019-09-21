package pl.smtc.patterns.creational.factory.SimpleFactory.product;

import pl.smtc.patterns.creational.factory.SimpleFactory.factory.Lamps;

public class DesktopLamp implements ILamp {
    private Lamps type;
    private String mounting;
    private String supply;

    public DesktopLamp(String mounting, String supply) {
        this.type = Lamps.DESKTOP;
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
