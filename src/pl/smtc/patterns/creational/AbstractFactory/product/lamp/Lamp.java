package pl.smtc.patterns.creational.AbstractFactory.product.lamp;

import pl.smtc.patterns.creational.AbstractFactory.product.mount.Mounting;
import pl.smtc.patterns.creational.AbstractFactory.product.source.Source;

public abstract class Lamp {
    protected ELamp type = ELamp.UNKNOWN;
    protected String mountPrerequisites = "";
    private Mounting mounting;
    private Source source;
    private String caseColor;
    private String caseProtection;

    protected Lamp(String caseColor) {
        this.caseColor = caseColor;
    }

    public void setMounting(Mounting mounting) {
        this.mounting = mounting;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public String getDescription() {
        String mountDetails = "mount with: " + mounting.getDescription();
        String sourceDetails = "light source: " + source.getDescription();
        String details = mountDetails + ", " + sourceDetails;
        return caseColor + " " + type + " LAMP [" + caseProtection + "] - " + details;
    }

    public ELamp getType() {
        return type;
    }

    public void setCaseProtection(String caseProtection) {
        this.caseProtection = caseProtection;
    }

    public boolean mount() {
        if (mounting != null) {
            System.out.println("************");
            System.out.println(type.toString() + " LAMP - MOUNT INSTRUCTIONS");
            System.out.println("Requires: " + mountPrerequisites);
            return mounting.mount();
        } else {
            System.out.println("Error: no mounting elements equipped with lamp.");
            return false;
        }
    }

    public boolean power(final boolean on) {
        System.out.println("************");
        System.out.println(type.toString() + " LAMP - POWER " + (on ? "ON" : "OFF"));
        if (source != null) {
            return source.power(on);
        } else {
            System.out.println("Error: no light source equipped.");
            return false;
        }
    }
}
