package pl.smtc.patterns.creational.SimpleFactory.product;

import pl.smtc.patterns.creational.SimpleFactory.factory.Lamps;

public interface ILamp {
    String getDescription();

    Lamps getType();
}
