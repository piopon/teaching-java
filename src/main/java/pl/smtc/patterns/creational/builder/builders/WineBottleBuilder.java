package pl.smtc.patterns.creational.builder.builders;

import pl.smtc.patterns.creational.builder.bottles.WineBottle;
import pl.smtc.patterns.creational.builder.support.ClosureType;
import pl.smtc.patterns.creational.builder.support.MaterialType;

public class WineBottleBuilder implements BottleBuilder {
    private double litreCapacity = 0.0;
    private MaterialType material = MaterialType.GLASS_WHITE;
    private ClosureType closure = ClosureType.CORK;
    private String label = "WINE";
    private int puntHeight = 0;

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
        if (ClosureType.SPORTS.equals(closure)) {
            throw new IllegalArgumentException("Wine bottle cannot have sport closure.");
        }
        this.closure = closure;
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public void setPuntHeight(int puntHeight) {
        this.puntHeight = puntHeight;
    }

    public WineBottle getResult() {
        return new WineBottle(litreCapacity, material, closure, label, puntHeight);
    }
}
