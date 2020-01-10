package pl.smtc.patterns.creational.builder.builders;

import pl.smtc.patterns.creational.builder.support.ClosureType;
import pl.smtc.patterns.creational.builder.support.MaterialType;

public interface BottleBuilder {
    void setCapacity(double litreCapacity);

    void setMaterial(MaterialType material);

    void setClosure(ClosureType closure);

    void setLabel(String label);

    void setPuntHeight(int puntHeight);
}