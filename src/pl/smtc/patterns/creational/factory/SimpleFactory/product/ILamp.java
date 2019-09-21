package pl.smtc.patterns.creational.factory.SimpleFactory.product;

import pl.smtc.patterns.creational.factory.SimpleFactory.factory.Lamps;

public interface ILamp {
    String getDescription();

    Lamps getType();
}
