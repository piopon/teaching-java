package pl.smtc.patterns.creational.builder.bottles;

import pl.smtc.patterns.creational.builder.support.ClosureType;
import pl.smtc.patterns.creational.builder.support.MaterialType;

public class WineBottle {
    private final double litreCapacity;
    private final MaterialType material;
    private final ClosureType closure;
    private final String label;
    private final int puntHeight;

    public WineBottle(double litreCapacity, MaterialType material, ClosureType closure, String label, int puntHeight) {
        this.litreCapacity = litreCapacity;
        this.material = material;
        this.closure = closure;
        this.label = label;
        this.puntHeight = puntHeight;
    }

    @Override
    public String toString() {
        String materialStr = material.toString().toLowerCase().replace("_", " ");
        String closureStr = closure.toString().toLowerCase().replace("_", " ");
        String bottleShape = materialStr + " with " + closureStr + " closure and " + puntHeight + "cm punt";
        return label + " bottle (" + litreCapacity + "l) - " + bottleShape;
    }
}
