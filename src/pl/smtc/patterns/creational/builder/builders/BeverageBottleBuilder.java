package pl.smtc.patterns.creational.builder.builders;

import pl.smtc.patterns.creational.builder.bottles.BeverageBottle;
import pl.smtc.patterns.creational.builder.support.ClosureType;
import pl.smtc.patterns.creational.builder.support.MaterialType;

public class BeverageBottleBuilder implements BottleBuilder {
    private double litreCapacity;
    private MaterialType material;
    private ClosureType closure;
    private String label;

    @Override
    public void setCapacity(double litreCapacity) {
        this.litreCapacity = litreCapacity;
    }

    @Override
    public void setMaterial(MaterialType material) {
        this.material = material;
    }

    @Override
    public void setClosure(ClosureType closure) throws IllegalArgumentException {
        if (ClosureType.CORK.equals(closure)) {
            throw new IllegalArgumentException("Beverage bottle cannot have cork closure.");
        }
        this.closure = closure;
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public void setPuntHeight(int puntHeight) throws IllegalArgumentException {
        throw new IllegalArgumentException("Beverage bottle does not have a punt.");
    }

    public BeverageBottle getResult() {
        return new BeverageBottle(litreCapacity, material, closure, label);
    }
}
