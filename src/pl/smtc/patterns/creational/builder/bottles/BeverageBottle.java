package pl.smtc.patterns.creational.builder.bottles;

import pl.smtc.patterns.creational.builder.support.ClosureType;
import pl.smtc.patterns.creational.builder.support.MaterialType;

public class BeverageBottle {
    private final double litreCapacity;
    private final MaterialType material;
    private final ClosureType closure;
    private final String label;

    public BeverageBottle(double litreCapacity, MaterialType material, ClosureType closure, String label) {
        this.litreCapacity = litreCapacity;
        this.material = material;
        this.closure = closure;
        this.label = label;
    }

    @Override
    public String toString() {
        String materialStr = material.toString().toLowerCase().replace("_", " ");
        String closureStr = closure.toString().toLowerCase();
        String bottleShape = materialStr + " with " + closureStr + " closure";
        return label + " bottle (" + litreCapacity + "l) - " + bottleShape;
    }
}
