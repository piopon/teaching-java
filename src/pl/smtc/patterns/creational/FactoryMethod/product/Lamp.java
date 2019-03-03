package pl.smtc.patterns.creational.FactoryMethod.product;

import pl.smtc.patterns.creational.FactoryMethod.factory.Lamps;

public abstract class Lamp {
    protected Lamps type = Lamps.UNKNOWN;
    private String caseProtection = "";
    private String caseColor = "";
    private String mounting;
    private String supply;

    protected Lamp(String mounting, String supply) {
        this.mounting = mounting;
        this.supply = supply;
    }

    public String getDescription() {
        String details = "mount: " + mounting + ", power: " + supply + ", protect: " + caseProtection;
        return caseColor + " " + type + " LAMP - " + details;
    }

    public void setCase(String protection, String color) {
        this.caseProtection = protection;
        this.caseColor = color;
    }

    public Lamps getType() {
        return type;
    }

    abstract public void power(boolean on);
}
