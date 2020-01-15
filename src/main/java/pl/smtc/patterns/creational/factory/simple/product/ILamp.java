package pl.smtc.patterns.creational.factory.simple.product;

import pl.smtc.patterns.creational.factory.simple.factory.Lamps;

public interface ILamp {
    String getDescription();

    Lamps getType();
}
