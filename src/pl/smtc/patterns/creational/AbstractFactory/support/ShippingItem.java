package pl.smtc.patterns.creational.AbstractFactory.support;

import pl.smtc.patterns.creational.AbstractFactory.product.lamp.Lamp;

public class ShippingItem {
    private String factoryName;
    private Lamp lamp;
    private int quantity;

    public ShippingItem(Lamp lamp, int quantity, String factory) {
        this.factoryName = factory;
        this.lamp = lamp;
        this.quantity = quantity;
    }

    public String getDescription() {
        return quantity + "x " + lamp.getDescription() + " [from: " + factoryName + "]";
    }

    public Lamp getLamp() {
        return lamp;
    }
}
